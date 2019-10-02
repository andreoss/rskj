/*
 * This file is part of RskJ
 * Copyright (C) 2019 RSK Labs Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package co.rsk.jsonrpc;

import com.fasterxml.jackson.annotation.JsonValue;

import static org.ethereum.rpc.TypeConverter.toQuantityJsonHex;

/**
 * A JSON-RPC result containing a quantity to be encoded in hexadecimal without leading zeroes.
 */
public class JsonRpcQuantityResult extends JsonRpcResult {
    private final long quantity;

    public JsonRpcQuantityResult(long quantity) {
        this.quantity = quantity;
    }

    @JsonValue
    @SuppressWarnings("unused")
    private String serialize() {
        return toQuantityJsonHex(quantity);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof JsonRpcQuantityResult)) {
            return false;
        }

        JsonRpcQuantityResult other = (JsonRpcQuantityResult) o;
        return this.quantity == other.quantity;
    }
}
