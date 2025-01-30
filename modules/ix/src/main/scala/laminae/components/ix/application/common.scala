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

import com.raquo.laminar.codecs.Codec

import laminae.components.ix.util.stringEnumCodec
enum ApplicationBreakpoint:
  case sm, md, lg

object ApplicationBreakpoint:
  val AsIsStringCodec: Codec[ApplicationBreakpoint, String] =
    stringEnumCodec(ApplicationBreakpoint.valueOf)
