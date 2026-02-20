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
import za.co.absa.db.mag.implicits.MapImplicits.MapEnhancements

class MapImplicitsUnitTests extends AnyFunSuite {

  test("getOrThrow returns value when key exists") {
    val map = Map("a" -> 1, "b" -> 2)
    assert(map.getOrThrow("a", new NoSuchElementException) == 1)
  }

  test("getOrThrow throws provided exception when key does not exist") {
    val map = Map("a" -> 1, "b" -> 2)
    val ex = new IllegalArgumentException("Key not found")
    val thrown = intercept[IllegalArgumentException] {
      map.getOrThrow("c", ex)
    }
    assert(thrown.getMessage == "Key not found")
  }
}
