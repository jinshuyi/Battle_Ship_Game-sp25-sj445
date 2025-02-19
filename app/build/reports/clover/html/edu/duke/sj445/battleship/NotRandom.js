var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":31,"id":970,"methods":[{"el":20,"sc":3,"sl":10},{"el":26,"sc":4,"sl":22},{"el":30,"sc":3,"sl":27}],"name":"NotRandom","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_12":{"methods":[{"sl":10}],"name":"test_throw","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":17},{"sl":18},{"sl":19}]},"test_18":{"methods":[{"sl":10}],"name":"test_display2Boards","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":17},{"sl":18},{"sl":19}]},"test_19":{"methods":[{"sl":10}],"name":"test_read_placement","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":17},{"sl":18},{"sl":19}]},"test_30":{"methods":[{"sl":10}],"name":"test_readCoordinate","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":17},{"sl":18},{"sl":19}]},"test_36":{"methods":[{"sl":10}],"name":"test_whatisAt","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":17},{"sl":18},{"sl":19}]},"test_37":{"methods":[{"sl":10},{"sl":22},{"sl":27}],"name":"test_main","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":23},{"sl":24},{"sl":25},{"sl":28},{"sl":29}]},"test_41":{"methods":[{"sl":10},{"sl":22},{"sl":27}],"name":"test_","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":23},{"sl":24},{"sl":25},{"sl":28},{"sl":29}]},"test_42":{"methods":[{"sl":10},{"sl":22},{"sl":27}],"name":"test_ai","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":17},{"sl":18},{"sl":19},{"sl":23},{"sl":24},{"sl":25},{"sl":28},{"sl":29}]},"test_7":{"methods":[{"sl":10}],"name":"test_null","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":17},{"sl":18},{"sl":19}]},"test_9":{"methods":[{"sl":10}],"name":"test_do_One_Placement","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":17},{"sl":18},{"sl":19}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [7, 18, 9, 12, 19, 36, 42, 37, 41, 30], [7, 18, 9, 12, 19, 36, 42, 37, 41, 30], [7, 18, 9, 12, 19, 36, 42, 37, 41, 30], [7, 18, 9, 12, 19, 36, 42, 37, 41, 30], [], [], [7, 18, 9, 12, 19, 36, 42, 37, 41, 30], [7, 18, 9, 12, 19, 36, 42, 37, 41, 30], [7, 18, 9, 12, 19, 36, 42, 37, 41, 30], [7, 18, 9, 12, 19, 36, 42, 37, 41, 30], [], [], [42, 37, 41], [42, 37, 41], [42, 37, 41], [42, 37, 41], [], [42, 37, 41], [42, 37, 41], [42, 37, 41], [], [], []]
