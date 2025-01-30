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

import com.raquo.laminar.api.L.*
import com.raquo.laminar.codecs.BooleanAsAttrPresenceCodec
import com.raquo.laminar.codecs.Codec
import com.raquo.laminar.codecs.IntAsStringCodec
import com.raquo.laminar.codecs.StringAsIsCodec

import scala.reflect.Enum

import scala.scalajs.js

private object util:
  inline def booleanAttr(name: String): HtmlAttr[Boolean] = htmlAttr(name, BooleanAsAttrPresenceCodec)

  inline def stringAttr(name: String): HtmlAttr[String] = htmlAttr(name, StringAsIsCodec)

  inline def intAttr(name: String): HtmlAttr[Int] = htmlAttr(name, IntAsStringCodec)

  def initialise(obj: js.Object): Unit = ()

  case class StringEnumCodec[A <: Enum](f: String => A) extends Codec[A, String]:
    override inline def decode(domValue: String): A = f(domValue)
    override inline def encode(scalaValue: A): String = scalaValue.toString

  inline def stringEnumCodec[A <: Enum](f: String => A): Codec[A, String] = StringEnumCodec[A](f)
