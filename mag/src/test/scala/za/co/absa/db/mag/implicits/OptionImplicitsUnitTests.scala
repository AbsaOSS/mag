/*
 * Copyright 2026 ABSA Group Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package za.co.absa.db.mag.implicits

import org.scalatest.funsuite.AnyFunSuite

class OptionImplicitsUnitTests extends AnyFunSuite {
  import OptionImplicits._

  test("getOrThrow returns value when option is defined") {
    val opt = Some(42)
    assert(opt.getOrThrow(new NoSuchElementException) == 42)
  }

  test("getOrThrow throws provided exception when option is None") {
    val opt: Option[Int] = None
    val ex = new IllegalArgumentException("No value present")
    val thrown = intercept[IllegalArgumentException] {
      opt.getOrThrow(ex)
    }
    assert(thrown.getMessage == "No value present")
  }

  test("@= returns true when option contains the value") {
    val opt = Some("hello")
    assert(opt @= "hello")
  }

  test("@= returns false when option does not contain the value") {
    val opt = Some("world")
    assert(!(opt @= "hello"))
  }

  test("@= returns false when option is None") {
    val opt: Option[String] = None
    assert(!(opt @= "anything"))
  }
}

