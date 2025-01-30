/****************************************************************
 * Copyright © Shuwari Africa Ltd.                              *
 *                                                              *
 * This file is licensed to you under the terms of the Apache   *
 * License Version 2.0 (the "License"); you may not use this    *
 * file except in compliance with the License. You may obtain   *
 * a copy of the License at:                                    *
 *                                                              *
 *     https://www.apache.org/licenses/LICENSE-2.0              *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, *
 * either express or implied. See the License for the specific  *
 * language governing permissions and limitations under the     *
 * License.                                                     *
 ****************************************************************/
package laminae.components.ix.buttons

import com.raquo.laminar.keys.HtmlAttr
import com.raquo.laminar.tags.CustomHtmlTag

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import org.scalajs.dom

import laminae.components.WebComponent
import laminae.components.ix.util.initialise
object Button extends WebComponent:
  override protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-button")

  inline def disabled: HtmlAttr[Boolean] = ButtonAttributes.disabled

  inline def ghost: HtmlAttr[Boolean] = ButtonAttributes.ghost

  inline def icon: HtmlAttr[String] = ButtonAttributes.icon // FIXME: Icon name library

  inline def loading: HtmlAttr[Boolean] = ButtonAttributes.loading

  inline def outline: HtmlAttr[Boolean] = ButtonAttributes.outline

  inline def variant: HtmlAttr[ButtonVariant] = ButtonAttributes.variant

  inline def `type`: HtmlAttr[ButtonType] = ButtonAttributes.`type`

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-button.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement

object DropdownButton extends WebComponent:

  override protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-dropdown-button")

  inline def disabled: HtmlAttr[Boolean] = ButtonAttributes.disabled

  inline def ghost: HtmlAttr[Boolean] = ButtonAttributes.ghost

  inline def icon: HtmlAttr[String] = ButtonAttributes.icon // FIXME: Icon name library

  inline def loading: HtmlAttr[Boolean] = ButtonAttributes.loading

  inline def outline: HtmlAttr[Boolean] = ButtonAttributes.outline

  inline def variant: HtmlAttr[ButtonVariant] = ButtonAttributes.variant

  inline def closeBehavior: HtmlAttr[ButtonCloseBehaviour] = ButtonAttributes.closeBehavior

  inline def label: HtmlAttr[String] = ButtonAttributes.label

  inline def placement: HtmlAttr[ButtonPlacement] = ButtonAttributes.placement

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-dropdown-button.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement
