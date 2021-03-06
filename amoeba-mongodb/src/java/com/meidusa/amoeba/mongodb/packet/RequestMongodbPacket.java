/*
 * Copyright amoeba.meidusa.com
 * 
 * 	This program is free software; you can redistribute it and/or modify it under the terms of 
 * the GNU AFFERO GENERAL PUBLIC LICENSE as published by the Free Software Foundation; either version 3 of the License, 
 * or (at your option) any later version. 
 * 
 * 	This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU AFFERO GENERAL PUBLIC LICENSE for more details. 
 * 	You should have received a copy of the GNU AFFERO GENERAL PUBLIC LICENSE along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.meidusa.amoeba.mongodb.packet;

import java.io.UnsupportedEncodingException;

import com.meidusa.amoeba.route.Request;

public class RequestMongodbPacket extends AbstractMongodbPacket implements Request {
	public int requestFlags = 0;
	public String fullCollectionName;

	protected void init(MongodbPacketBuffer buffer) {
		super.init(buffer);
		requestFlags = buffer.readInt();
		fullCollectionName = buffer.readCString();
	}

	protected void write2Buffer(MongodbPacketBuffer buffer)
			throws UnsupportedEncodingException {
		super.write2Buffer(buffer);
		buffer.writeInt(requestFlags);
		buffer.writeCString(fullCollectionName);
	}

	public boolean isPrepared() {
		return false;
	}

	public boolean isRead() {
		return false;
	}
}
