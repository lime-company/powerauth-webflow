/*
 * Copyright 2018 Lime - HighTech Solutions s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.getlime.security.powerauth.lib.dataadapter.model.entity.attribute;

import io.getlime.security.powerauth.lib.dataadapter.model.enumeration.ValueFormatType;

/**
 * Class representing an operation form field attribute for generic key-value pair.
 *
 * @author Petr Dvorak, petr@lime-company.eu
 */
public class KeyValueAttribute extends AttributeFormatted {

    private String value;

    /**
     * Default constructor.
     */
    public KeyValueAttribute() {
        this.type = Type.KEY_VALUE;
    }

    /**
     * Constructor with value format type.
     * @param valueFormatType Value format type.
     */
    public KeyValueAttribute(ValueFormatType valueFormatType) {
        this.type = Type.KEY_VALUE;
        this.valueFormatType = valueFormatType;
    }

    /**
     * Constructor with all details.
     * @param id Attribute ID.
     * @param label Label.
     * @param value Value.
     * @param valueFormatType Value format type.
     * @param formattedValue Formatted value.
     */
    public KeyValueAttribute(String id, String label, String value, ValueFormatType valueFormatType, String formattedValue) {
        this.type = Type.KEY_VALUE;
        this.id = id;
        this.label = label;
        this.value = value;
        this.valueFormatType = valueFormatType;
        this.formattedValue = formattedValue;
    }

    /**
     * Get attribute value.
     * @return Attribute value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Set attribute value.
     * @param value Attribute value.
     */
    public void setValue(String value) {
        this.value = value;
    }
}