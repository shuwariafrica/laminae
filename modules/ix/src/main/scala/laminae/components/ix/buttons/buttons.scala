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
package laminae.components.ix.buttons

import com.raquo.laminar.keys.HtmlAttr
import com.raquo.laminar.tags.CustomHtmlTag

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import org.scalajs.dom

import laminae.components.WebComponent
//import laminae.components.ix.buttons.common.ButtonCloseBehaviour
import laminae.components.ix.util.initialise
object Button extends WebComponent:

  type ButtonVariant = common.ButtonVariant
  inline def ButtonVariant: common.ButtonVariant.type = common.ButtonVariant

  type ButtonType = common.ButtonType
  inline def ButtonType: common.ButtonType.type = common.ButtonType

  override protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-button")

  inline def disabled: HtmlAttr[Boolean] = common.ButtonAttributes.disabled

  inline def ghost: HtmlAttr[Boolean] = common.ButtonAttributes.ghost

  inline def icon: HtmlAttr[String] = common.ButtonAttributes.icon // FIXME: Icon name library

  inline def loading: HtmlAttr[Boolean] = common.ButtonAttributes.loading

  inline def outline: HtmlAttr[Boolean] = common.ButtonAttributes.outline

  inline def variant: HtmlAttr[ButtonVariant] = common.ButtonAttributes.variant

  inline def `type`: HtmlAttr[ButtonType] = common.ButtonAttributes.`type`

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-button.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement

object DropdownButton extends WebComponent:

  type ButtonVariant = common.ButtonVariant

  inline def ButtonVariant: common.ButtonVariant.type = common.ButtonVariant

  type ButtonType = common.ButtonType

  inline def ButtonType: common.ButtonType.type = common.ButtonType
  
  inline def ButtonPlacement: common.ButtonPlacement.type = common.ButtonPlacement

  type ButtonPlacement = common.ButtonPlacement

  type ButtonCloseBehaviour = common.ButtonCloseBehaviour

  inline def ButtonCloseBehaviour: common.ButtonCloseBehaviour.type = common.ButtonCloseBehaviour

  override protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-dropdown-button")

  inline def disabled: HtmlAttr[Boolean] = common.ButtonAttributes.disabled

  inline def ghost: HtmlAttr[Boolean] = common.ButtonAttributes.ghost

  inline def icon: HtmlAttr[String] = common.ButtonAttributes.icon // FIXME: Icon name library

  inline def loading: HtmlAttr[Boolean] = common.ButtonAttributes.loading

  inline def outline: HtmlAttr[Boolean] = common.ButtonAttributes.outline

  inline def variant: HtmlAttr[ButtonVariant] = common.ButtonAttributes.variant

  inline def closeBehavior: HtmlAttr[ButtonCloseBehaviour] = common.ButtonAttributes.closeBehavior

  inline def label: HtmlAttr[String] = common.ButtonAttributes.label

  inline def placement: HtmlAttr[ButtonPlacement] = common.ButtonAttributes.placement

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-dropdown-button.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement
