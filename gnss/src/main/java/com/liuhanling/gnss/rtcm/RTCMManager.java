package com.liuhanling.gnss.rtcm;

import com.liuhanling.gnss.bean.GnssData;
import com.liuhanling.gnss.bean.ReferenceStation;
import com.liuhanling.gnss.listener.RTCMParserHandler;
import com.liuhanling.gnss.listener.RTCMParserListener;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: Copyright (c) 太昌电子 2018</p>
 *
 * @author liuhanling
 * @date 2019-04-08 10:59
 */
public class RTCMManager {

    private RTCMParser mRTCMParser;
    private RTCMParserListener mRTCMParserListener;

    public RTCMManager() {
        mRTCMParser = new RTCMParserImpl(new RTCMParserHandler() {
            @Override
            public void onSARP(ReferenceStation station) {
                if (mRTCMParserListener != null) {
                    mRTCMParserListener.onSARP(station);
                }
            }

            @Override
            public void onGNSS(GnssData data) {
                if (mRTCMParserListener != null) {
                    mRTCMParserListener.onGNSS(data);
                }
            }

            @Override
            public void onException(Exception e) {
                if (mRTCMParserListener != null) {
                    mRTCMParserListener.onSARP(null);
                    mRTCMParserListener.onGNSS(null);
                }
            }
        });
    }

    public void setRTCMParserListener(RTCMParserListener listener) {
        this.mRTCMParserListener = listener;
    }

    public void parseRTCM(byte[] data) {
        mRTCMParser.parseRTCM(data);
    }
}
