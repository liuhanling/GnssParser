package com.liuhanling.gnss.listener;

import com.liuhanling.gnss.bean.GnssLocation;
import com.liuhanling.gnss.bean.GnssSatellite;

import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: Copyright (c) 太昌电子 2018</p>
 *
 * @author liuhanling
 * @date 2019-03-13 17:35
 */
public interface NMEAParserListener {

    void onLocation(GnssLocation location);

    void onSatellites(List<GnssSatellite> satellites);

    void onPower(int level);
}
