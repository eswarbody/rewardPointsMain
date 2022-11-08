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
        "total": "4568",
        "ok": "-",
        "ko": "4568"
    },
    "meanResponseTime": {
        "total": "4308",
        "ok": "-",
        "ko": "4308"
    },
    "standardDeviation": {
        "total": "230",
        "ok": "-",
        "ko": "230"
    },
    "percentiles1": {
        "total": "4305",
        "ok": "-",
        "ko": "4305"
    },
    "percentiles2": {
        "total": "4539",
        "ok": "-",
        "ko": "4539"
    },
    "percentiles3": {
        "total": "4553",
        "ok": "-",
        "ko": "4553"
    },
    "percentiles4": {
        "total": "4565",
        "ok": "-",
        "ko": "4565"
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
        "total": "4568",
        "ok": "-",
        "ko": "4568"
    },
    "meanResponseTime": {
        "total": "4308",
        "ok": "-",
        "ko": "4308"
    },
    "standardDeviation": {
        "total": "230",
        "ok": "-",
        "ko": "230"
    },
    "percentiles1": {
        "total": "4305",
        "ok": "-",
        "ko": "4305"
    },
    "percentiles2": {
        "total": "4539",
        "ok": "-",
        "ko": "4539"
    },
    "percentiles3": {
        "total": "4553",
        "ok": "-",
        "ko": "4553"
    },
    "percentiles4": {
        "total": "4565",
        "ok": "-",
        "ko": "4565"
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
