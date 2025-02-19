var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":208,"id":129,"methods":[{"el":23,"sc":3,"sl":21},{"el":35,"sc":3,"sl":26},{"el":83,"sc":3,"sl":39},{"el":181,"sc":3,"sl":87},{"el":187,"sc":3,"sl":184},{"el":191,"sc":3,"sl":189},{"el":194,"sc":3,"sl":192},{"el":199,"sc":3,"sl":196}],"name":"RectangleShip","sl":17}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":21},{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_with_Carrier","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":119},{"sl":128},{"sl":137},{"sl":146},{"sl":157},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_10":{"methods":[{"sl":26},{"sl":39},{"sl":87},{"sl":184},{"sl":189},{"sl":196}],"name":"test_doPlacementPhase","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":46},{"sl":48},{"sl":49},{"sl":50},{"sl":52},{"sl":56},{"sl":57},{"sl":58},{"sl":62},{"sl":63},{"sl":68},{"sl":69},{"sl":70},{"sl":72},{"sl":76},{"sl":77},{"sl":78},{"sl":81},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":92},{"sl":93},{"sl":94},{"sl":95},{"sl":96},{"sl":98},{"sl":99},{"sl":100},{"sl":101},{"sl":102},{"sl":104},{"sl":110},{"sl":111},{"sl":112},{"sl":113},{"sl":114},{"sl":118},{"sl":119},{"sl":128},{"sl":129},{"sl":130},{"sl":131},{"sl":132},{"sl":133},{"sl":134},{"sl":135},{"sl":137},{"sl":146},{"sl":147},{"sl":148},{"sl":149},{"sl":150},{"sl":151},{"sl":152},{"sl":153},{"sl":157},{"sl":158},{"sl":159},{"sl":160},{"sl":162},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":173},{"sl":179},{"sl":185},{"sl":186},{"sl":190},{"sl":197},{"sl":198}]},"test_12":{"methods":[{"sl":21},{"sl":26},{"sl":39},{"sl":87},{"sl":196}],"name":"test_V2ShipFactory_Carrier_L","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":62},{"sl":63},{"sl":68},{"sl":72},{"sl":76},{"sl":77},{"sl":78},{"sl":81},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":119},{"sl":128},{"sl":137},{"sl":146},{"sl":147},{"sl":148},{"sl":149},{"sl":150},{"sl":151},{"sl":152},{"sl":153},{"sl":157},{"sl":167},{"sl":179},{"sl":197},{"sl":198}]},"test_13":{"methods":[{"sl":21},{"sl":26},{"sl":39},{"sl":87},{"sl":196}],"name":"test_V2ShipFactory_Battleship_L","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":48},{"sl":52},{"sl":56},{"sl":57},{"sl":58},{"sl":62},{"sl":81},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":92},{"sl":98},{"sl":104},{"sl":110},{"sl":111},{"sl":112},{"sl":113},{"sl":114},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":197},{"sl":198}]},"test_15":{"methods":[{"sl":21},{"sl":26},{"sl":39},{"sl":87},{"sl":196}],"name":"test_V2ShipFactory_Carrier_U","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":62},{"sl":63},{"sl":64},{"sl":65},{"sl":68},{"sl":72},{"sl":76},{"sl":81},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":119},{"sl":120},{"sl":121},{"sl":122},{"sl":123},{"sl":124},{"sl":125},{"sl":126},{"sl":128},{"sl":137},{"sl":146},{"sl":157},{"sl":167},{"sl":179},{"sl":197},{"sl":198}]},"test_19":{"methods":[{"sl":21},{"sl":26},{"sl":39},{"sl":87},{"sl":184},{"sl":189},{"sl":196}],"name":"test_main","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":46},{"sl":48},{"sl":52},{"sl":56},{"sl":57},{"sl":58},{"sl":62},{"sl":63},{"sl":64},{"sl":65},{"sl":68},{"sl":69},{"sl":70},{"sl":72},{"sl":76},{"sl":81},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":92},{"sl":93},{"sl":94},{"sl":95},{"sl":96},{"sl":98},{"sl":104},{"sl":110},{"sl":111},{"sl":112},{"sl":113},{"sl":114},{"sl":118},{"sl":119},{"sl":120},{"sl":121},{"sl":122},{"sl":123},{"sl":124},{"sl":125},{"sl":126},{"sl":128},{"sl":129},{"sl":130},{"sl":131},{"sl":132},{"sl":133},{"sl":134},{"sl":135},{"sl":137},{"sl":146},{"sl":157},{"sl":158},{"sl":159},{"sl":160},{"sl":162},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":173},{"sl":179},{"sl":185},{"sl":186},{"sl":190},{"sl":197},{"sl":198}]},"test_21":{"methods":[{"sl":26},{"sl":87},{"sl":184},{"sl":192}],"name":"test_display_ship_3by5","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":193}]},"test_23":{"methods":[{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_with_new_constructor","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_24":{"methods":[{"sl":21},{"sl":26},{"sl":39},{"sl":87},{"sl":196}],"name":"test_V2ShipFactory_Carrier_R","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":62},{"sl":63},{"sl":68},{"sl":69},{"sl":70},{"sl":72},{"sl":76},{"sl":81},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":119},{"sl":128},{"sl":129},{"sl":130},{"sl":131},{"sl":132},{"sl":133},{"sl":134},{"sl":135},{"sl":137},{"sl":146},{"sl":157},{"sl":167},{"sl":179},{"sl":197},{"sl":198}]},"test_26":{"methods":[{"sl":21},{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_enemy_board","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":158},{"sl":162},{"sl":163},{"sl":164},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":173},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_27":{"methods":[{"sl":21},{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_fireAt","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":158},{"sl":162},{"sl":163},{"sl":164},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_28":{"methods":[{"sl":26},{"sl":87},{"sl":184}],"name":"test_getDisplay","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":185},{"sl":186}]},"test_3":{"methods":[{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_checkCollision","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":158},{"sl":159},{"sl":160},{"sl":162},{"sl":163},{"sl":164},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_34":{"methods":[{"sl":21},{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_with_Battleship","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_36":{"methods":[{"sl":21},{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_with_Destroyer","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":173},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_38":{"methods":[{"sl":21},{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_with_Submarine","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":158},{"sl":162},{"sl":163},{"sl":164},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_39":{"methods":[{"sl":21},{"sl":26},{"sl":39},{"sl":87},{"sl":196}],"name":"test_V2ShipFactory_Battleship_D","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":48},{"sl":52},{"sl":53},{"sl":54},{"sl":56},{"sl":62},{"sl":81},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":92},{"sl":98},{"sl":104},{"sl":105},{"sl":106},{"sl":107},{"sl":108},{"sl":110},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":197},{"sl":198}]},"test_4":{"methods":[{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"Test_displayMyBoardWithEnemyNextToIt","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":173},{"sl":174},{"sl":175},{"sl":176},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_42":{"methods":[{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_getCoordinates","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_5":{"methods":[{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_with_recordHitAt","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_50":{"methods":[{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_checkMyRule","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":158},{"sl":159},{"sl":160},{"sl":162},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_51":{"methods":[{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_is_Sunk","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_52":{"methods":[{"sl":21},{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_get_name","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_54":{"methods":[{"sl":21},{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_all_Sunk_or_Not","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":158},{"sl":162},{"sl":163},{"sl":164},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_56":{"methods":[{"sl":21},{"sl":26},{"sl":39},{"sl":87},{"sl":196}],"name":"test_V2ShipFactory_Carrier_d","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":62},{"sl":63},{"sl":68},{"sl":72},{"sl":73},{"sl":74},{"sl":76},{"sl":81},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":119},{"sl":128},{"sl":137},{"sl":138},{"sl":139},{"sl":140},{"sl":141},{"sl":142},{"sl":143},{"sl":144},{"sl":146},{"sl":157},{"sl":167},{"sl":179},{"sl":197},{"sl":198}]},"test_57":{"methods":[{"sl":21},{"sl":26},{"sl":39},{"sl":87},{"sl":196}],"name":"test_V2ShipFactory_Battleship_U","pass":true,"statements":[{"sl":22},{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":46},{"sl":48},{"sl":52},{"sl":56},{"sl":62},{"sl":81},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":92},{"sl":93},{"sl":94},{"sl":95},{"sl":96},{"sl":98},{"sl":104},{"sl":110},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":197},{"sl":198}]},"test_58":{"methods":[{"sl":26},{"sl":87},{"sl":184},{"sl":189}],"name":"test_do_placement","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":173},{"sl":179},{"sl":185},{"sl":186},{"sl":190}]},"test_7":{"methods":[{"sl":26},{"sl":87},{"sl":184},{"sl":192}],"name":"test_whatIsAt","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34},{"sl":88},{"sl":89},{"sl":90},{"sl":91},{"sl":118},{"sl":157},{"sl":167},{"sl":179},{"sl":185},{"sl":186},{"sl":193}]},"test_8":{"methods":[{"sl":26}],"name":"test_with_makeCoords","pass":true,"statements":[{"sl":28},{"sl":29},{"sl":30},{"sl":31},{"sl":34}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [52, 13, 54, 36, 0, 12, 24, 26, 27, 39, 19, 34, 56, 57, 38, 15], [52, 13, 54, 36, 0, 12, 24, 26, 27, 39, 19, 34, 56, 57, 38, 15], [], [], [], [10, 52, 28, 13, 42, 54, 36, 7, 0, 8, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [], [10, 52, 28, 13, 42, 54, 36, 7, 0, 8, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 8, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 8, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 8, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [], [], [10, 52, 28, 13, 42, 54, 36, 7, 0, 8, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [], [], [], [], [10, 13, 12, 24, 39, 19, 56, 57, 15], [10, 13, 12, 24, 39, 19, 56, 57, 15], [10, 13, 12, 24, 39, 19, 56, 57, 15], [10, 13, 12, 24, 39, 19, 56, 57, 15], [10, 13, 12, 24, 39, 19, 56, 57, 15], [10, 13, 39, 19, 57], [10, 19, 57], [10, 19, 57], [], [10, 13, 39, 19, 57], [10], [10], [], [10, 13, 39, 19, 57], [39], [39], [], [10, 13, 39, 19, 57], [10, 13, 19], [10, 13, 19], [], [], [], [10, 13, 12, 24, 39, 19, 56, 57, 15], [10, 12, 24, 19, 56, 15], [19, 15], [19, 15], [], [], [10, 12, 24, 19, 56, 15], [10, 24, 19], [10, 24, 19], [], [10, 12, 24, 19, 56, 15], [56], [56], [], [10, 12, 24, 19, 56, 15], [10, 12], [10, 12], [], [], [10, 13, 12, 24, 39, 19, 56, 57, 15], [], [], [], [], [], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 13, 39, 19, 57], [10, 19, 57], [10, 19, 57], [10, 19, 57], [10, 19, 57], [], [10, 13, 39, 19, 57], [10], [10], [10], [10], [], [10, 13, 39, 19, 57], [39], [39], [39], [39], [], [10, 13, 39, 19, 57], [10, 13, 19], [10, 13, 19], [10, 13, 19], [10, 13, 19], [], [], [], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 0, 12, 24, 19, 56, 15], [19, 15], [19, 15], [19, 15], [19, 15], [19, 15], [19, 15], [19, 15], [], [10, 0, 12, 24, 19, 56, 15], [10, 24, 19], [10, 24, 19], [10, 24, 19], [10, 24, 19], [10, 24, 19], [10, 24, 19], [10, 24, 19], [], [10, 0, 12, 24, 19, 56, 15], [56], [56], [56], [56], [56], [56], [56], [], [10, 0, 12, 24, 19, 56, 15], [10, 12], [10, 12], [10, 12], [10, 12], [10, 12], [10, 12], [10, 12], [], [], [], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 54, 26, 27, 19, 50, 38, 3], [10, 19, 50, 3], [10, 19, 50, 3], [], [10, 54, 26, 27, 19, 50, 38, 3], [54, 26, 27, 38, 3], [54, 26, 27, 38, 3], [], [], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 36, 26, 58, 4, 19], [10, 36, 26, 58, 4, 19], [10, 36, 26, 58, 4, 19], [10, 36, 26, 58, 4, 19], [], [10, 36, 26, 58, 4, 19], [4], [4], [4], [], [], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [], [], [], [], [10, 52, 28, 42, 54, 36, 7, 0, 26, 21, 58, 27, 4, 5, 19, 23, 34, 50, 38, 51, 3], [10, 52, 28, 42, 54, 36, 7, 0, 26, 21, 58, 27, 4, 5, 19, 23, 34, 50, 38, 51, 3], [10, 52, 28, 42, 54, 36, 7, 0, 26, 21, 58, 27, 4, 5, 19, 23, 34, 50, 38, 51, 3], [], [], [10, 52, 42, 54, 36, 0, 26, 58, 27, 4, 5, 19, 23, 34, 50, 38, 51, 3], [10, 52, 42, 54, 36, 0, 26, 58, 27, 4, 5, 19, 23, 34, 50, 38, 51, 3], [], [7, 21], [7, 21], [], [], [10, 13, 12, 24, 39, 19, 56, 57, 15], [10, 13, 12, 24, 39, 19, 56, 57, 15], [10, 13, 12, 24, 39, 19, 56, 57, 15], [], [], [], [], [], [], [], [], [], []]
