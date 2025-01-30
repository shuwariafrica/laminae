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
//package africa.shuwari.laminar.components
//package ix.application
//
////import africa.shuwari.laminar.components.{Slot, WebComponent}
////import africa.shuwari.laminar.components.{Slot, WebComponent}
//import com.raquo.laminar.api.L.{HtmlAttr, htmlAttr, htmlTag}
//import com.raquo.laminar.codecs.{BooleanAsAttrPresenceCodec, StringAsIsCodec}
//import com.raquo.laminar.tags.HtmlTag
//import org.scalajs.dom
//
//import scala.scalajs.js
//import scala.scalajs.js.annotation.JSImport
//
//object BasicNavigation extends WebComponent:
//
//  @js.native
//  trait RawElement extends js.Object
//
//  @js.native
//  @JSImport("@siemens/ix/dist/collection/components/basic-navigation/basic-navigation.js")
//  object RawImport extends js.Object
//
//  initialise(RawImport)
//
//  override type Ref = dom.html.Element & RawElement
//
//  protected val tag: HtmlTag[Ref] = htmlTag("ix-basic-navigation")
//
//  val applicationName: HtmlAttr[String] = htmlAttr("application-name", StringAsIsCodec)
//
//  val hideHeader: HtmlAttr[Boolean] = htmlAttr("hide-header", BooleanAsAttrPresenceCodec)
//
//  object slot:
//    def logo: Slot = Slot("logo")
