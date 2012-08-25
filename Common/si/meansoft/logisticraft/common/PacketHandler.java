/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at 
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Mrbrutal
 ******************************************************************************/

package si.meansoft.logisticraft.common;

import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler{

	@Override
	public void onPacketData(NetworkManager manager, Packet250CustomPayload packet, Player player) {
		
	}

}
