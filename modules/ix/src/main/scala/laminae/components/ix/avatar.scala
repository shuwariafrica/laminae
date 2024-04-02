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

//import africa.shuwari.laminar.components.{Slot, WebComponent}
import com.raquo.laminar.api.L.HtmlAttr
import com.raquo.laminar.api.L.htmlAttr
import com.raquo.laminar.codecs.StringAsIsCodec
import com.raquo.laminar.tags.CustomHtmlTag

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import org.scalajs.dom

import laminae.components.WebComponent
import laminae.components.ix.util.initialise

object Avatar extends WebComponent:

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-avatar.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement

  protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-avatar")

  val extra: HtmlAttr[String] = htmlAttr("extra", StringAsIsCodec)

  val image: HtmlAttr[String] = htmlAttr("image", StringAsIsCodec)

  val initials: HtmlAttr[String] = htmlAttr("initials", StringAsIsCodec)

  val username: HtmlAttr[String] = htmlAttr("username", StringAsIsCodec)
