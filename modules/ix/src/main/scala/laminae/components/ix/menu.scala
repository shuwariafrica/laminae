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
package laminae.components.ix

import com.raquo.laminar.api.L
import com.raquo.laminar.api.L.eventProp
import com.raquo.laminar.api.L.htmlAttr
import com.raquo.laminar.codecs.IntAsStringCodec
import com.raquo.laminar.codecs.StringAsIsCodec
import com.raquo.laminar.keys.EventProp
import com.raquo.laminar.keys.HtmlAttr
import com.raquo.laminar.tags.CustomHtmlTag

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import org.scalajs.dom
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.html.Element

import laminae.components.Slot
import laminae.components.WebComponent
import laminae.components.ix.util.booleanAttr
import laminae.components.ix.util.initialise
import laminae.components.ix.util.intAttr
import laminae.components.ix.util.stringAttr

/** `ix-menu` component. See [[https://ix.siemens.io/docs/controls/navigation/vertical-tabs#properties-ix-menu]] */
object Menu extends WebComponent:
  override type Ref = Element & RawElement

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-menu.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-menu")

  /** Should only be set if you use ix-menu standalone */
  val applicationDescription: HtmlAttr[String] = stringAttr("application-description")

  /** Should only be set if you use ix-menu standalone */
  val applicationName: HtmlAttr[String] = stringAttr("application-name")

//  val enableMapExpand: HtmlAttr[Boolean] = htmlAttr("enable-map-expand", BooleanAsTrueFalseStringCodec)

  /** Is settings tab is visible */
  val enableSettings: HtmlAttr[Boolean] = booleanAttr("enable-settings")

  /** Show toggle between light and dark variant. Only if the provided theme have implemented both! */
  val enableToggleTheme: HtmlAttr[Boolean] = booleanAttr("enable-toggle-theme")

  val expand: HtmlAttr[Boolean] = booleanAttr("expand")

  val i18nCollapse: HtmlAttr[String] = stringAttr("i-1-8n-collapse")

  val i18nExpand: HtmlAttr[String] = stringAttr("i-1-8n-expand")

  /** Accessibility i18n label for the burger menu of the sidebar */
  val i18nExpandSidebar: HtmlAttr[String] = stringAttr("i-1-8n-expand-sidebar")

  val i18nLegal: HtmlAttr[String] = stringAttr("i-1-8n-legal")

//  val i18nMore: HtmlAttr[String] = stringAttr("i-1-8n-more", StringAsIsCodec)

  val i18nSettings: HtmlAttr[String] = stringAttr("i-1-8n-settings")

  val i18nToggleTheme: HtmlAttr[String] = stringAttr("i-1-8n-toggle-theme")

//  val maxVisibleMenuItems: HtmlAttr[Int] = htmlAttr("max-visible-menu-items", IntAsStringCodec)

  /** Menu stays pinned to the left */
  val pinned: HtmlAttr[Boolean] = booleanAttr("pinned")

  /** Is about tab visible */
  val showAbout: HtmlAttr[Boolean] = booleanAttr("show-about")

  /** Is settings tab visible */
  val showSettings: HtmlAttr[Boolean] = booleanAttr("show-settings")

  object events:

    val expandChange: EventProp[Nothing] = eventProp("expandChange")

    val mapExpandChange: EventProp[Nothing] = eventProp("mapExpandChange")

object MenuItem extends WebComponent:
  override type Ref = Element & RawElement

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-menu-item.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-menu-item")

  val active: HtmlAttr[Boolean] = booleanAttr("active")
  val disabled: HtmlAttr[Boolean] = booleanAttr("disabled")
  val home: HtmlAttr[Boolean] = booleanAttr("home")
  val notifications: HtmlAttr[Int] = intAttr("notifications")
  val icon: HtmlAttr[String] = stringAttr("icon")

  object slot:
    val bottom: Slot = Slot("bottom")

object MenuCategory extends WebComponent:
  override type Ref = Element & RawElement

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-menu-category.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-menu-category")

  val label: HtmlAttr[String] = stringAttr("label")
  val notifications: HtmlAttr[Int] = intAttr("notifications")
  val icon: HtmlAttr[String] = stringAttr("icon")

object MenuAvatar extends WebComponent:
  override type Ref = Element & RawElement
  @js.native
  trait RawElement extends js.Object
  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-menu-avatar.entry")
  object RawImport extends js.Object
  initialise(RawImport)
  override protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-menu-avatar")

  /** First line of text */
  val top: HtmlAttr[String] = stringAttr("top")

  /** Second line of text */
  val bottom: HtmlAttr[String] = stringAttr("bottom")

  /** Display an avatar image */
  val image: HtmlAttr[String] = stringAttr("image")

  /** Display the initials of the user. Will be overriden by image */
  val initials: HtmlAttr[String] = stringAttr("initials")

  /** Use for translation */
  val i18nLogout: HtmlAttr[String] = stringAttr("i18nLogout")

  object events:
    /** Logout click */
    val logoutClick: EventProp[MouseEvent] = eventProp("logoutClick")

object MenuAvatarItem extends WebComponent:
  override type Ref = Element & RawElement
  @js.native
  trait RawElement extends js.Object
  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-menu-avatar-item.entry")
  object RawImport extends js.Object
  initialise(RawImport)
  override protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-menu-avatar-item")

  val label: HtmlAttr[String] = stringAttr("label")
  val icon: HtmlAttr[String] = stringAttr("icon")

  object events:
    val itemClick: EventProp[MouseEvent] = eventProp("itemClick")
