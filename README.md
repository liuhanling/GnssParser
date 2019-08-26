[![](https://jitpack.io/v/liuhanling/GnssParser.svg)](https://jitpack.io/#liuhanling/GnssParser)

# GnssParser
### 解析NMEA和RTCM

## 添加Gradle依赖

1.项目 build.gradle 的 repositories 添加:
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
2.模块 build.gradle 的 dependencies 添加:
 ```
dependencies {
    ...
    implementation 'com.github.liuhanling:GnssParser:1.0.0'
}
```

## 使用说明
# 1.解析NMEA
```
GnssService.getInstance().setNMEAParserListener(new NMEAParserListener() {
    @Override
    public void onLocation(GnssLocation location) {
        //updateGnssStatus(location);
    }

    @Override
    public void onSatellites(List<GnssSatellite> satellites) {
        //updateGnssStatus(satellites);
    }

    @Override
    public void onPower(int level) {
        //updatePowerStatus(level);
    }
});

GnssService.getInstance().parseNMEA(nmea);
```

# 2.解析NMEA
```
GnssService.getInstance().setRTCMParserListener(new RTCMParserListener() {
    @Override
    public void onSARP(ReferenceStation station) {
        // updateStation(station);
    }

    @Override
    public void onGNSS(GnssData data) {\
        // updateSatellite(data);
    }
 });
 
 GnssService.getInstance().parseRTCM(rtcm);
```

