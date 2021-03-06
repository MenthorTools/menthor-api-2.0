package net.menthor.core.traits

/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016  Menthor Consulting in Information Technology
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in the
 * Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.fasterxml.jackson.databind.annotation.JsonSerialize

/**
 * Menthor CORE Property. Usually a association end-point or an attribute.
 * @author John Guerson
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
trait MProperty implements MNamedElement {

    protected Boolean ordered
    protected Boolean dependency
    protected Boolean derived
    protected int lowerBound
    protected int upperBound

    //=============================
    // Getters
    //=============================

    Boolean isOrdered(){ return ordered }

    Boolean isDerived(){ return derived }

    Boolean isDependency() { return dependency }

    int getLowerBound() { return lowerBound }

    int getUpperBound() { return upperBound }

    //=============================
    // Setters
    //=============================

    void setOrdered(boolean value){ this.ordered = value }

    void setDerived(boolean value){ this.derived = value }

    void setDependency(boolean value){ this.dependency = value }

    void setLowerBound(int value) { this.lowerBound = value }

    void setUpperBound(int value) { this.upperBound = value }

    void setCardinalities(int lower, int upper){
        lowerBound = lower
        upperBound = upper
    }
}
