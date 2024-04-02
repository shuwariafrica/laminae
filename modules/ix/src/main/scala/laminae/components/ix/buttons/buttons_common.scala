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

import com.raquo.laminar.codecs.BooleanAsAttrPresenceCodec
import com.raquo.laminar.codecs.Codec
import com.raquo.laminar.codecs.StringAsIsCodec
import com.raquo.laminar.keys.HtmlAttr

import scala.annotation.targetName

import laminae.components.ix.util.booleanAttr
import laminae.components.ix.util.stringAttr
import laminae.components.ix.util.stringEnumCodec
enum ButtonType:
  case button, submit

enum ButtonVariant:
  case primary, secondary

enum ButtonPlacement:
  @targetName("bottom_end")   case `bottom-end`
  @targetName("bottom_start") case `bottom-start`
  @targetName("left_end")     case `left-end`
  @targetName("left_start")   case `left-start`
  @targetName("right_end")    case `right-end`
  @targetName("right_start")  case `right-start`
  @targetName("top_end")      case `top-end`
  @targetName("top_start")    case `top-start`

enum ButtonCloseBehaviour:
  case both, inside, outside

object ButtonAttributes:

  // Common
  val disabled: HtmlAttr[Boolean] = booleanAttr("disabled")

  val ghost: HtmlAttr[Boolean] = booleanAttr("ghost")

  val icon: HtmlAttr[String] = stringAttr("icon") // FIXME: Icon name library

  val loading: HtmlAttr[Boolean] = booleanAttr("loading")

  val outline: HtmlAttr[Boolean] = booleanAttr("outline")

  val variant: HtmlAttr[ButtonVariant] = HtmlAttr("variant", stringEnumCodec(ButtonVariant.valueOf))

  val `type`: HtmlAttr[ButtonType] = HtmlAttr("type", stringEnumCodec(ButtonType.valueOf))

  // Dropdown Button
  val closeBehavior: HtmlAttr[ButtonCloseBehaviour] =
    HtmlAttr("close-behaviour", stringEnumCodec(ButtonCloseBehaviour.valueOf))

  val label: HtmlAttr[String] = stringAttr("label")

  val placement: HtmlAttr[ButtonPlacement] = HtmlAttr("placement", stringEnumCodec(ButtonPlacement.valueOf))
