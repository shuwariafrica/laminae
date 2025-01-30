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
package laminae.components.ix.application

import com.raquo.laminar.api.L.HtmlAttr
import com.raquo.laminar.api.L.htmlAttr
import com.raquo.laminar.tags.CustomHtmlTag

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import org.scalajs.dom

import laminae.components.WebComponent
import laminae.components.ix.util.booleanAttr
import laminae.components.ix.util.initialise

object Application extends WebComponent:

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-application.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement

  protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-application")

  // val appSwitchConfig: HtmlAttr[String] = stringAttr("appSwitchConfig") TODO

  // val breakpoints: HtmlAttr[Set[ApplicationBreakpoint]] TODO

  val forceBreakpoint: HtmlAttr[ApplicationBreakpoint] =
    htmlAttr("force-breakpoint", ApplicationBreakpoint.AsIsStringCodec)

// TODO val theme: HtmlAttr[String]

  val themeSystemAppearance: HtmlAttr[Boolean] = booleanAttr("theme-system-appearance")
