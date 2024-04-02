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

  inline def stringEnumCodec[A <: Enum](f: String => A): Codec[A, String] =
    new Codec[A, String]:
      override def decode(domValue: String): A = f(domValue)

      override def encode(scalaValue: A): String = scalaValue.toString
