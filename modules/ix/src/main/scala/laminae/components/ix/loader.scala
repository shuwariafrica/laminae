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

import scala.concurrent.Future

import scala.scalajs.js
import scala.scalajs.js.Promise
import scala.scalajs.js.annotation.JSImport

object loader:

  private object RawImports:
    @js.native
    @JSImport("@siemens/ix/loader", "applyPolyfills")
    def applyPolyfills(): Promise[js.Any] = js.native

    @js.native
    @JSImport("@siemens/ix/loader", "defineCustomElements")
    def defineCustomElements(): Promise[js.Any] = js.native

    @js.native
    @JSImport("@siemens/ix-icons/loader", "applyPolyfills")
    def applyIconPolyfills(): Promise[js.Any] = js.native

    @js.native
    @JSImport("@siemens/ix-icons/loader", "defineCustomElements")
    def defineIconCustomElements(): Promise[js.Any] = js.native

  inline def applyPolyfills(): Future[js.Any] = RawImports.applyIconPolyfills().toFuture

  inline def defineCustomElements(): Future[js.Any] = RawImports.defineCustomElements().toFuture

  inline def applyIconPolyfills(): Future[js.Any] = RawImports.applyIconPolyfills().toFuture

  inline def defineIconCustomElements(): Future[js.Any] = RawImports.defineIconCustomElements().toFuture
