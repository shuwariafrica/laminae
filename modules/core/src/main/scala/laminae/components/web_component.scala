/*****************************************************************
 * Copyright © Shuwari Africa Ltd. All rights reserved.          *
 *                                                               *
 * Shuwari Africa Ltd. licenses this file to you under the terms *
 * of the Apache License Version 2.0 (the "License"); you may    *
 * not use this file except in compliance with the License. You  *
 * may obtain a copy of the License at:                          *
 *                                                               *
 *     https://www.apache.org/licenses/LICENSE-2.0               *
 *                                                               *
 * Unless required by applicable law or agreed to in writing,    *
 * software distributed under the License is distributed on an   *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,  *
 * either express or implied. See the License for the specific   *
 * language governing permissions and limitations under the      *
 * License.                                                      *
 *****************************************************************/
package laminae.components

import com.raquo.laminar.api.L
import com.raquo.laminar.api.L.*
import com.raquo.laminar.codecs.StringAsIsCodec
import com.raquo.laminar.nodes.ReactiveHtmlElement
import com.raquo.laminar.tags.CustomHtmlTag

import scala.annotation.targetName

import org.scalajs.dom

trait WebComponent:

  protected val tag: CustomHtmlTag[Ref]

  type Ref <: dom.HTMLElement

  type TransformFunction = this.type => Mod[ReactiveHtmlElement[Ref]]

  protected val RawImport: scala.scalajs.js.Any

  final def apply(mods: (Mod[ReactiveHtmlElement[Ref]] | TransformFunction)*): HtmlElement = tag(
    mods
      .map {
        case mod: Mod[? >: ReactiveHtmlElement[Ref]] => (_: this.type) => mod
        case mod: Function[? >: this.type, ? <: ReactiveHtmlElement[Ref]] => mod
      }
      .map(_(this))*
  )

final case class Slot(name: String):

  @targetName("assignElement")
  inline def :=(element: HtmlElement): Inserter = <--(Val(appendHtmlElementSlot(element)))

  @targetName("assignSvgElement")
  inline def :=(element: SvgElement): Inserter = <--(Val(appendSvgElementSlot(element)))

  @targetName("assignElements")
  inline def :=(elements: Seq[HtmlElement | SvgElement])(using DummyImplicit): Inserter = <--(Val(elements))

  @targetName("bindElementObservable")
  inline def <--(elementObservable: Observable[HtmlElement | SvgElement]): Inserter =
    child <-- elementObservable.map(appendSlot)

  @targetName("bindElementsObservable")
  inline def <--(elementsObservable: Observable[Seq[HtmlElement | SvgElement]])(using DummyImplicit): Inserter =
    children <-- elementsObservable.map(_.map(appendSlot))

  private inline def appendSlot[A <: HtmlElement | SvgElement]: A => A =
    case el: HtmlElement => appendHtmlElementSlot(el)
    case el: SvgElement => appendSvgElementSlot(el)

  private inline def appendHtmlElementSlot[A <: HtmlElement](el: A): el.type = el.amend(slot := name)
  private inline def appendSvgElementSlot[A <: SvgElement](el: A): el.type =
    el.amend(svg.svgAttr("slot", StringAsIsCodec, None) := name)
