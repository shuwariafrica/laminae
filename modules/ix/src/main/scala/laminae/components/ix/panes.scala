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
package laminae.components.ix

import com.raquo.laminar.api.L
import com.raquo.laminar.api.L.HtmlAttr
import com.raquo.laminar.api.L.eventProp
import com.raquo.laminar.api.L.htmlAttr
import com.raquo.laminar.codecs.Codec
import com.raquo.laminar.keys.EventProp
import com.raquo.laminar.tags.CustomHtmlTag

import scala.annotation.targetName

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import org.scalajs.dom

import laminae.components.WebComponent
import laminae.components.ix.util.booleanAttr
import laminae.components.ix.util.initialise
import laminae.components.ix.util.stringAttr
import laminae.components.ix.util.stringEnumCodec
enum PaneComposition:
  case bottom, left, right, top

enum PaneSize:
  case `240px`, `320px`, `360px`, `480px`, `600px`
  @targetName("33_per_cent") case `33%`
  @targetName("50_per_cent") case `50%`

enum PaneVariant:
  case inline, floating

enum PaneLayoutOrientation:
  @targetName("full_horizontal") case `full-horizontal`
  @targetName("full_vertical")   case `full-vertical`

object Pane extends WebComponent:

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-pane.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement

  protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-pane")

  val borderless: HtmlAttr[Boolean] = PaneCommonAttributes.borderless

  val composition: HtmlAttr[PaneComposition] = htmlAttr("composition", stringEnumCodec(PaneComposition.valueOf))

  val expanded: HtmlAttr[Boolean] = booleanAttr("expanded")

  val heading: HtmlAttr[String] = stringAttr("heading")

  val hideOnCollapse: HtmlAttr[Boolean] = booleanAttr("hide-on-collapse")

  val icon: HtmlAttr[String] = stringAttr("icon")

  val size: HtmlAttr[PaneSize] = htmlAttr("size", stringEnumCodec(PaneSize.valueOf))

  val variant: HtmlAttr[PaneVariant] = PaneCommonAttributes.variant

  object events:

    val borderlessChanged: EventProp[dom.Event] = eventProp("borderlessChanged")

    val expandedChanged: EventProp[dom.Event] = eventProp("expandedChanged")

    val variantChanged: EventProp[dom.Event] = eventProp("variantChanged")

object PaneLayout extends WebComponent:

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-pane-layout.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement

  protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-pane-layout")

  val layout: HtmlAttr[PaneLayoutOrientation] = htmlAttr("layout", stringEnumCodec(PaneLayoutOrientation.valueOf))

  val borderless: HtmlAttr[Boolean] = PaneCommonAttributes.borderless

  val variant: HtmlAttr[PaneVariant] = PaneCommonAttributes.variant

object PaneCommonAttributes:
  val borderless: HtmlAttr[Boolean] = booleanAttr("borderless")

  val variant: HtmlAttr[PaneVariant] = htmlAttr("variant", stringEnumCodec(PaneVariant.valueOf))
