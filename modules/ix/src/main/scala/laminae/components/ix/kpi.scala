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

import com.raquo.laminar.codecs.StringAsIsCodec
import com.raquo.laminar.keys.HtmlAttr
import com.raquo.laminar.tags.CustomHtmlTag

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import org.scalajs.dom

import laminae.components.WebComponent
import laminae.components.ix.util.initialise
import laminae.components.ix.util.stringAttr
import laminae.components.ix.util.stringEnumCodec

object KPI extends WebComponent:

  enum Orientation:
    case horizontal, vertical

  enum State:
    case alarm, neutral, warning

  enum Value:
    case number, string

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-kpi.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement

  protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-kpi")

  val label: HtmlAttr[String] = stringAttr("label")

  val orientation: HtmlAttr[Orientation] = HtmlAttr("orientation", stringEnumCodec(Orientation.valueOf))

  val state: HtmlAttr[State] = HtmlAttr("state", stringEnumCodec(State.valueOf))

  val unit: HtmlAttr[String] = stringAttr("unit")

  val value: HtmlAttr[Value] = HtmlAttr("state", stringEnumCodec(Value.valueOf))
