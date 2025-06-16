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

import com.raquo.laminar.keys.HtmlAttr
import com.raquo.laminar.tags.CustomHtmlTag

import scala.annotation.targetName

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import org.scalajs.dom

import laminae.components.WebComponent
import laminae.components.ix.util.booleanAttr
import laminae.components.ix.util.initialise
import laminae.components.ix.util.intAttr
import laminae.components.ix.util.stringEnumCodec

object LayoutGrid extends WebComponent:

  enum Gap:
    @targetName("gap_8")  case `8`
    @targetName("gap_12") case `12`
    @targetName("gap_16") case `16`
    @targetName("gap_24") case `24`

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-layout-grid.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement

  protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-layout-grid")

  val columns: HtmlAttr[Int] = intAttr("columns")

  val gap: HtmlAttr[Gap] = HtmlAttr("gap", stringEnumCodec(Gap.valueOf))

  val noMargin: HtmlAttr[Boolean] = booleanAttr("no-margin")

object Col extends WebComponent:

  enum Size:
    @targetName("size_1")    case `1`
    @targetName("size_2")    case `2`
    @targetName("size_3")    case `3`
    @targetName("size_4")    case `4`
    @targetName("size_5")    case `5`
    @targetName("size_6")    case `6`
    @targetName("size_7")    case `7`
    @targetName("size_8")    case `8`
    @targetName("size_9")    case `9`
    @targetName("size_10")   case `10`
    @targetName("size_11")   case `11`
    @targetName("size_12")   case `12`
    @targetName("size_auto") case `auto`

  @js.native
  trait RawElement extends js.Object

  @js.native
  @JSImport("@siemens/ix/dist/esm/ix-col.entry")
  object RawImport extends js.Object

  initialise(RawImport)

  override type Ref = dom.html.Element & RawElement

  protected val tag: CustomHtmlTag[Ref] = CustomHtmlTag("ix-col")

  val size: HtmlAttr[Size] = HtmlAttr("size", stringEnumCodec(Size.valueOf))

  val sizeSm: HtmlAttr[Size] = HtmlAttr("size-sm", stringEnumCodec(Size.valueOf))

  val sizeMd: HtmlAttr[Size] = HtmlAttr("size-md", stringEnumCodec(Size.valueOf))

  val sizeLg: HtmlAttr[Size] = HtmlAttr("size-lg", stringEnumCodec(Size.valueOf))
