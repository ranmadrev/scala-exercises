/*
 *  scala-exercises
 *
 *  Copyright 2015-2019 47 Degrees, LLC. <http://www.47deg.com>
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
 *
 */

package org.scalaexercises.exercises.persistence.domain

import shapeless.{HList, LabelledGeneric}
import shapeless.ops.hlist.ToTraversable
import shapeless.ops.record.Keys

private[domain] class FieldNamesPartlyApplied[CC] {
  // format: OFF
  def apply[LG <: HList, K <: HList]()(
    implicit
    lgen: LabelledGeneric.Aux[CC, LG],
    keys: Keys.Aux[LG, K],
    toList: ToTraversable[K, List]
  ): List[String] = toList(keys()).map { case Symbol(s) ⇒ s.toLowerCase }
  // format: ON
}
