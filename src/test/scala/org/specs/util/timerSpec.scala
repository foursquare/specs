/**
 * Copyright (c) 2007-2011 Eric Torreborre <etorreborre@yahoo.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software. Neither the name of specs nor the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written permission.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package org.specs.util
import org.specs._
import org.specs.runner._

class timerSpec extends SpecificationWithJUnit {
  "A timer" should {
    "display 0 seconds if not stopped after being created" in {
      TestTimer().hms must_== "0 second"
    }
    "display the elapsed time if stopped after being started" in {
      val timer = TestTimer()
      timer.start
      timer.currentTime = 1000L
      timer.stop
      timer.hms must_== "1 second"
      timer.preciseTime must beMatching("1 second, \\d+ ms")
    }
    "allow several nested starts and stops returning cumulated times" in {
      val timer = TestTimer()
      timer.start
      timer.start
      timer.currentTime = 1000L
      timer.stop mustMatch "1 second"
      timer.currentTime = 2000L
      timer.stop mustMatch "2 seconds"
    }
  }
  case class TestTimer() extends SimpleTimer {
    var currentTime = 0L
    override def getTime = currentTime
  }
}
