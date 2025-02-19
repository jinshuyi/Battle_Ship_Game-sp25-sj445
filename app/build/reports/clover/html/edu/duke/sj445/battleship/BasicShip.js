var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":112,"id":432,"methods":[{"el":30,"sc":3,"sl":22},{"el":38,"sc":3,"sl":35},{"el":44,"sc":3,"sl":40},{"el":51,"sc":3,"sl":46},{"el":57,"sc":3,"sl":53},{"el":69,"sc":3,"sl":59},{"el":80,"sc":3,"sl":71},{"el":87,"sc":3,"sl":82},{"el":99,"sc":3,"sl":89},{"el":111,"sc":3,"sl":102}],"name":"BasicShip","sl":9}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":22},{"sl":46}],"name":"test_with_Carrier","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":50}]},"test_10":{"methods":[{"sl":22},{"sl":40},{"sl":46},{"sl":53},{"sl":82},{"sl":89}],"name":"test_doPlacementPhase","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42},{"sl":50},{"sl":54},{"sl":85},{"sl":86},{"sl":92},{"sl":93},{"sl":94}]},"test_12":{"methods":[{"sl":22},{"sl":35},{"sl":46}],"name":"test_V2ShipFactory_Carrier_L","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":37},{"sl":50}]},"test_13":{"methods":[{"sl":22},{"sl":35},{"sl":46}],"name":"test_V2ShipFactory_Battleship_L","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":37},{"sl":50}]},"test_15":{"methods":[{"sl":22},{"sl":35},{"sl":46}],"name":"test_V2ShipFactory_Carrier_U","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":37},{"sl":50}]},"test_19":{"methods":[{"sl":22},{"sl":35},{"sl":40},{"sl":46},{"sl":53},{"sl":59},{"sl":71},{"sl":82},{"sl":89},{"sl":102}],"name":"test_main","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":37},{"sl":42},{"sl":50},{"sl":54},{"sl":62},{"sl":63},{"sl":64},{"sl":65},{"sl":68},{"sl":74},{"sl":75},{"sl":76},{"sl":77},{"sl":85},{"sl":86},{"sl":92},{"sl":93},{"sl":94},{"sl":97},{"sl":104},{"sl":105},{"sl":106},{"sl":107},{"sl":110}]},"test_21":{"methods":[{"sl":22},{"sl":40},{"sl":46},{"sl":53},{"sl":82},{"sl":89}],"name":"test_display_ship_3by5","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42},{"sl":50},{"sl":54},{"sl":85},{"sl":86},{"sl":92},{"sl":93},{"sl":94}]},"test_23":{"methods":[{"sl":22},{"sl":46}],"name":"test_with_new_constructor","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":50}]},"test_24":{"methods":[{"sl":22},{"sl":35},{"sl":46}],"name":"test_V2ShipFactory_Carrier_R","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":37},{"sl":50}]},"test_26":{"methods":[{"sl":22},{"sl":40},{"sl":46},{"sl":53},{"sl":71},{"sl":82},{"sl":89}],"name":"test_enemy_board","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42},{"sl":50},{"sl":54},{"sl":74},{"sl":75},{"sl":76},{"sl":77},{"sl":85},{"sl":86},{"sl":92},{"sl":93},{"sl":94},{"sl":97}]},"test_27":{"methods":[{"sl":22},{"sl":40},{"sl":46},{"sl":53},{"sl":59},{"sl":71}],"name":"test_fireAt","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42},{"sl":50},{"sl":54},{"sl":62},{"sl":63},{"sl":64},{"sl":68},{"sl":74},{"sl":75},{"sl":76},{"sl":77}]},"test_28":{"methods":[{"sl":22},{"sl":46},{"sl":53},{"sl":82},{"sl":89}],"name":"test_getDisplay","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":50},{"sl":54},{"sl":85},{"sl":86},{"sl":92},{"sl":93},{"sl":94},{"sl":97}]},"test_3":{"methods":[{"sl":22},{"sl":40},{"sl":46},{"sl":53},{"sl":82},{"sl":89}],"name":"test_checkCollision","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42},{"sl":50},{"sl":54},{"sl":85},{"sl":86},{"sl":92},{"sl":93},{"sl":94}]},"test_34":{"methods":[{"sl":22},{"sl":46}],"name":"test_with_Battleship","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":50}]},"test_36":{"methods":[{"sl":22},{"sl":35},{"sl":46}],"name":"test_with_Destroyer","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":37},{"sl":50}]},"test_38":{"methods":[{"sl":22},{"sl":35},{"sl":46}],"name":"test_with_Submarine","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":37},{"sl":50}]},"test_39":{"methods":[{"sl":22},{"sl":35},{"sl":46}],"name":"test_V2ShipFactory_Battleship_D","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":37},{"sl":50}]},"test_4":{"methods":[{"sl":22},{"sl":40},{"sl":46},{"sl":53},{"sl":82},{"sl":89}],"name":"Test_displayMyBoardWithEnemyNextToIt","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42},{"sl":50},{"sl":54},{"sl":85},{"sl":86},{"sl":92},{"sl":93},{"sl":94},{"sl":97}]},"test_42":{"methods":[{"sl":22},{"sl":40}],"name":"test_getCoordinates","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42}]},"test_5":{"methods":[{"sl":22},{"sl":46},{"sl":53},{"sl":59},{"sl":71},{"sl":82}],"name":"test_with_recordHitAt","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":50},{"sl":54},{"sl":55},{"sl":62},{"sl":63},{"sl":64},{"sl":65},{"sl":74},{"sl":75},{"sl":76},{"sl":77},{"sl":85},{"sl":86}]},"test_50":{"methods":[{"sl":22},{"sl":40},{"sl":46},{"sl":53},{"sl":82},{"sl":89}],"name":"test_checkMyRule","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42},{"sl":50},{"sl":54},{"sl":85},{"sl":86},{"sl":92},{"sl":93},{"sl":94}]},"test_51":{"methods":[{"sl":22},{"sl":46},{"sl":53},{"sl":59},{"sl":71}],"name":"test_is_Sunk","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":50},{"sl":54},{"sl":62},{"sl":63},{"sl":64},{"sl":68},{"sl":74},{"sl":75},{"sl":76},{"sl":77}]},"test_52":{"methods":[{"sl":22}],"name":"test_get_name","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29}]},"test_54":{"methods":[{"sl":22},{"sl":40},{"sl":46},{"sl":53},{"sl":59},{"sl":71}],"name":"test_all_Sunk_or_Not","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42},{"sl":50},{"sl":54},{"sl":62},{"sl":63},{"sl":64},{"sl":65},{"sl":68},{"sl":74},{"sl":75},{"sl":76},{"sl":77}]},"test_56":{"methods":[{"sl":22},{"sl":35},{"sl":46}],"name":"test_V2ShipFactory_Carrier_d","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":37},{"sl":50}]},"test_57":{"methods":[{"sl":22},{"sl":35},{"sl":46}],"name":"test_V2ShipFactory_Battleship_U","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":37},{"sl":50}]},"test_58":{"methods":[{"sl":22},{"sl":40},{"sl":46},{"sl":53},{"sl":82},{"sl":89}],"name":"test_do_placement","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42},{"sl":50},{"sl":54},{"sl":85},{"sl":86},{"sl":92},{"sl":93},{"sl":94}]},"test_7":{"methods":[{"sl":22},{"sl":40},{"sl":46},{"sl":53},{"sl":82},{"sl":89}],"name":"test_whatIsAt","pass":true,"statements":[{"sl":23},{"sl":24},{"sl":25},{"sl":26},{"sl":27},{"sl":29},{"sl":42},{"sl":50},{"sl":54},{"sl":85},{"sl":86},{"sl":92},{"sl":93},{"sl":94}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [], [10, 52, 28, 13, 42, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [], [], [], [], [], [13, 36, 12, 24, 39, 19, 56, 57, 38, 15], [], [13, 36, 12, 24, 39, 19, 56, 57, 38, 15], [], [], [10, 42, 54, 7, 26, 21, 58, 27, 4, 19, 50, 3], [], [10, 42, 54, 7, 26, 21, 58, 27, 4, 19, 50, 3], [], [], [], [10, 28, 13, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [], [], [], [10, 28, 13, 54, 36, 7, 0, 12, 24, 26, 21, 58, 27, 4, 5, 39, 19, 23, 34, 56, 50, 57, 38, 15, 51, 3], [], [], [10, 28, 54, 7, 26, 21, 58, 27, 4, 5, 19, 50, 51, 3], [10, 28, 54, 7, 26, 21, 58, 27, 4, 5, 19, 50, 51, 3], [5], [], [], [], [54, 27, 5, 19, 51], [], [], [54, 27, 5, 19, 51], [54, 27, 5, 19, 51], [54, 27, 5, 19, 51], [54, 5, 19], [], [], [54, 27, 19, 51], [], [], [54, 26, 27, 5, 19, 51], [], [], [54, 26, 27, 5, 19, 51], [54, 26, 27, 5, 19, 51], [54, 26, 27, 5, 19, 51], [54, 26, 27, 5, 19, 51], [], [], [], [], [10, 28, 7, 26, 21, 58, 4, 5, 19, 50, 3], [], [], [10, 28, 7, 26, 21, 58, 4, 5, 19, 50, 3], [10, 28, 7, 26, 21, 58, 4, 5, 19, 50, 3], [], [], [10, 28, 7, 26, 21, 58, 4, 19, 50, 3], [], [], [10, 28, 7, 26, 21, 58, 4, 19, 50, 3], [10, 28, 7, 26, 21, 58, 4, 19, 50, 3], [10, 28, 7, 26, 21, 58, 4, 19, 50, 3], [], [], [28, 26, 4, 19], [], [], [], [], [19], [], [19], [19], [19], [19], [], [], [19], [], []]
