var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "20",
        "ok": "0",
        "ko": "20"
    },
    "minResponseTime": {
        "total": "4069",
        "ok": "-",
        "ko": "4069"
    },
    "maxResponseTime": {
        "total": "4373",
        "ok": "-",
        "ko": "4373"
    },
    "meanResponseTime": {
        "total": "4220",
        "ok": "-",
        "ko": "4220"
    },
    "standardDeviation": {
        "total": "135",
        "ok": "-",
        "ko": "135"
    },
    "percentiles1": {
        "total": "4220",
        "ok": "-",
        "ko": "4220"
    },
    "percentiles2": {
        "total": "4363",
        "ok": "-",
        "ko": "4363"
    },
    "percentiles3": {
        "total": "4373",
        "ok": "-",
        "ko": "4373"
    },
    "percentiles4": {
        "total": "4373",
        "ok": "-",
        "ko": "4373"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 20,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    }
},
contents: {
"req_pointspermonth-6b820": {
        type: "REQUEST",
        name: "PointsPerMonth",
path: "PointsPerMonth",
pathFormatted: "req_pointspermonth-6b820",
stats: {
    "name": "PointsPerMonth",
    "numberOfRequests": {
        "total": "20",
        "ok": "0",
        "ko": "20"
    },
    "minResponseTime": {
        "total": "4069",
        "ok": "-",
        "ko": "4069"
    },
    "maxResponseTime": {
        "total": "4373",
        "ok": "-",
        "ko": "4373"
    },
    "meanResponseTime": {
        "total": "4220",
        "ok": "-",
        "ko": "4220"
    },
    "standardDeviation": {
        "total": "135",
        "ok": "-",
        "ko": "135"
    },
    "percentiles1": {
        "total": "4220",
        "ok": "-",
        "ko": "4220"
    },
    "percentiles2": {
        "total": "4363",
        "ok": "-",
        "ko": "4363"
    },
    "percentiles3": {
        "total": "4373",
        "ok": "-",
        "ko": "4373"
    },
    "percentiles4": {
        "total": "4373",
        "ok": "-",
        "ko": "4373"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 20,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
