package com.chao.kotlinfuel

class VideoModal {
    /**
     * {
    "id": 22,
    "title": "人在囧途",
    "star": "4.5",
    "publicTime": "2010-06-04",
    "type": "喜剧",
    "toStar": "叶伟民",
    "performer": "徐峥/王宝强/李曼/李小璐/左小青/张歆艺/黄小蕾/马健/邱林",
    "country": "中国大陆",
    "alias": "Lost on Journey",
    "videoDescribe": "　　大老板李成功（徐峥 饰）遇上挤奶工牛耿（王宝强 饰）之后，旅途便频出状况。被情人逼迫回长沙老家跟老婆摊牌的李成功，机场遭遇到前往长沙讨债的乌鸦嘴牛耿。牛耿人如其名，不但耿直憨厚，而且透出一股傻气。先是登机前安检一口气喝完一大罐牛奶，后来又飞机上让乘务员开窗，好不容易折腾到飞机到达长沙上空，结果让他咒得因长沙大雪飞机被迫返航。无奈挤上火车硬座车厢的李成功刚松了一口气，却又一次在人群中看到牛耿。牛耿就像李成功生命中的瘟神一样，只要他“金口一开”，便会出现如他所言的意外。由于途中的频频意外，两人从火车换乘巴士，又从巴士爬上拖拉机。尽管牛耿的乌鸦嘴让李成功吃尽苦头，但这个混身透着傻气的青年却用自己真诚与乐观感染着李成功。一路的颠簸之后，两人最终到达长沙又回到各自的生活轨迹中去，然而旅途中所遭遇的种种却影响着两人之后的生活……\n　　本片由香港资深电影人文隽担当监制。",
    "img": "https://file.peakchao.com:188/人在囧途.webp",
    "video": "https://file.peakchao.com:188/人在囧途.mp4",
    "videoTime": "87"
    }
     */
    var id: Int = 0
    var title: String? = null
    var star: String? = null
    var publicTime: String? = null
    var type: String? = null
    var toStar: String? = null
    var performer: String? = null
    var country: String? = null
    var alias: String? = null
    var videoDescribe: String? = null
    var img: String? = null
    var video: String? = null
    var videoTime: String? = null

    override fun toString(): String {
        return "VideoModal(id=$id, title=$title, star=$star, publicTime=$publicTime, type=$type, toStar=$toStar, performer=$performer, country=$country, alias=$alias, videoDescribe=$videoDescribe, img=$img, video=$video, videoTime=$videoTime)"
    }

}