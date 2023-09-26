package com.example.learn.algorithm.json;

import com.alibaba.fastjson2.JSONObject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JsonUtil {

    public static void main(String[] args) throws Exception {
        String data = "{\n" +
                "    \"dm-internal-000001\": {\n" +
                "        \"mappings\": {\n" +
                "            \"dynamic_templates\": [\n" +
                "                {\n" +
                "                    \"objectToKeyword\": {\n" +
                "                        \"match_mapping_type\": \"object\",\n" +
                "                        \"mapping\": {\n" +
                "                            \"type\": \"object\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"allToKeyword\": {\n" +
                "                        \"match_mapping_type\": \"*\",\n" +
                "                        \"mapping\": {\n" +
                "                            \"ignore_above\": 8191,\n" +
                "                            \"type\": \"keyword\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"date_detection\": false,\n" +
                "            \"properties\": {\n" +
                "                \"@meta\": {\n" +
                "                    \"properties\": {\n" +
                "                        \"_eid\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"_full_index\": {\n" +
                "                            \"type\": \"text\",\n" +
                "                            \"analyzer\": \"standard\"\n" +
                "                        },\n" +
                "                        \"_offset\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"_pttid\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"date_day\": {\n" +
                "                            \"type\": \"long\"\n" +
                "                        },\n" +
                "                        \"date_dsecond\": {\n" +
                "                            \"type\": \"long\"\n" +
                "                        },\n" +
                "                        \"date_hour\": {\n" +
                "                            \"type\": \"long\"\n" +
                "                        },\n" +
                "                        \"date_minute\": {\n" +
                "                            \"type\": \"long\"\n" +
                "                        },\n" +
                "                        \"date_month\": {\n" +
                "                            \"type\": \"long\"\n" +
                "                        },\n" +
                "                        \"date_second\": {\n" +
                "                            \"type\": \"long\"\n" +
                "                        },\n" +
                "                        \"date_week\": {\n" +
                "                            \"type\": \"long\"\n" +
                "                        },\n" +
                "                        \"date_year\": {\n" +
                "                            \"type\": \"long\"\n" +
                "                        },\n" +
                "                        \"host\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"index\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"indexTime\": {\n" +
                "                            \"type\": \"date\"\n" +
                "                        },\n" +
                "                        \"index_time\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"metatype\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"raw\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"index\": false,\n" +
                "                            \"ignore_above\": 8191,\n" +
                "                            \"copy_to\": [\n" +
                "                                \"@meta._full_index\"\n" +
                "                            ]\n" +
                "                        },\n" +
                "                        \"source\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"time\": {\n" +
                "                            \"type\": \"date\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                \"KafkaObject\": {\n" +
                "                    \"properties\": {\n" +
                "                        \"clientId\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"coordinator\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"createTime\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"groupid\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"host\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"memberId\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"minute\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"offset\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"owner\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"partition\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"partitionAssignor\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"state\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"topic\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                \"_eid\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"_offset\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"_pttid\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"accessid\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"appName\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"category\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"clientIP\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"content\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"dashboardID\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"dashboardName\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"datetag\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"details\": {\n" +
                "                    \"properties\": {\n" +
                "                        \"_eid\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"_offset\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"_pttid\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"_raw\": {\n" +
                "                            \"properties\": {\n" +
                "                                \"highlight\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"trunc\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"value\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                }\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"_time\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"auditObject\": {\n" +
                "                            \"properties\": {\n" +
                "                                \"applicationName\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"className\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"ip\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"logArgs\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"mapping\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"method\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"methodName\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"model\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"operation\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"remoteAddr\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"timestamp\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"uri\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"user\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                }\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"count\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"host\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"index\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"ip\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"metatype\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"name\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"source\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"type\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                \"diskAvail\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"diskCapacity\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"diskUsage\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"diskUse\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"edgeid\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"endTime\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"events\": {\n" +
                "                    \"properties\": {\n" +
                "                        \"duration_in_millis\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"filtered\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"in\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"out\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"queue_push_duration_in_millis\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                \"from\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"host\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"http_address\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"jvm\": {\n" +
                "                    \"properties\": {\n" +
                "                        \"gc_collectors\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"mem\": {\n" +
                "                            \"properties\": {\n" +
                "                                \"heap_init_in_bytes\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"heap_max_in_bytes\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"non_heap_init_in_bytes\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"non_heap_max_in_bytes\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                }\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"pid\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"start_time_in_millis\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"version\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"vm_name\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                \"level\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"metric\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"name\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"os\": {\n" +
                "                    \"properties\": {\n" +
                "                        \"arch\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"available_processors\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"name\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"version\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                \"pageTitle\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"panelID\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"panelName\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"pipeline\": {\n" +
                "                    \"properties\": {\n" +
                "                        \"batch_delay\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"batch_size\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"workers\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                \"pipelineContent\": {\n" +
                "                    \"properties\": {\n" +
                "                        \"batch_delay\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"batch_size\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"config_reload_automatic\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"config_reload_interval\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"dead_letter_queue_enabled\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"ephemeral_id\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"workers\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                \"pipelineName\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"platform\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"process\": {\n" +
                "                    \"properties\": {\n" +
                "                        \"cpu\": {\n" +
                "                            \"properties\": {\n" +
                "                                \"load_average\": {\n" +
                "                                    \"properties\": {\n" +
                "                                        \"15m\": {\n" +
                "                                            \"type\": \"keyword\",\n" +
                "                                            \"ignore_above\": 8191\n" +
                "                                        },\n" +
                "                                        \"1m\": {\n" +
                "                                            \"type\": \"keyword\",\n" +
                "                                            \"ignore_above\": 8191\n" +
                "                                        },\n" +
                "                                        \"5m\": {\n" +
                "                                            \"type\": \"keyword\",\n" +
                "                                            \"ignore_above\": 8191\n" +
                "                                        }\n" +
                "                                    }\n" +
                "                                },\n" +
                "                                \"percent\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                },\n" +
                "                                \"total_in_millis\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                }\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"max_file_descriptors\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"mem\": {\n" +
                "                            \"properties\": {\n" +
                "                                \"total_virtual_in_bytes\": {\n" +
                "                                    \"type\": \"keyword\",\n" +
                "                                    \"ignore_above\": 8191\n" +
                "                                }\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"open_file_descriptors\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        },\n" +
                "                        \"peak_open_file_descriptors\": {\n" +
                "                            \"type\": \"keyword\",\n" +
                "                            \"ignore_above\": 8191\n" +
                "                        }\n" +
                "                    }\n" +
                "                },\n" +
                "                \"search\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"snapshot\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"source\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"spl\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"startTime\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"status\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"tags\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"title\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"type\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"userAgent\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"userName\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                },\n" +
                "                \"visitURL\": {\n" +
                "                    \"type\": \"keyword\",\n" +
                "                    \"ignore_above\": 8191\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        JSONObject map = JSONObject.parseObject(data);
        Map<String, Object> propertiesMap = getKeyMap(map, "dm-internal-000001.mappings.properties");
        Set<String> retKeySet = loopRetKey("", propertiesMap);
        System.out.println(retKeySet);
    }

    private static Map getKeyMap(Map map, String k) {
        Map retMap = map;
        for(String s : k.split("\\.")){
            retMap = (Map)retMap.get(s);
        }
        return retMap;
    }

    private static Set<String> loopRetKey(String prev, Map<String, Object> elemMap) {
        Set<String> retKeySet = new HashSet<>();
        for(String key:elemMap.keySet()) {
            if(key.startsWith("_") || key.startsWith("date_") || key.startsWith("@meta")) {
                continue;
            }

            Map<String, Object> oneMap = getKeyMap(elemMap, key);
            // 如果不存在properties，则说明为叶子结点
            if(!oneMap.containsKey("properties")){
                retKeySet.add(prev + key);
            }else{
                // 遍历写入对象结点
                Map<String, Object> twoMap = getKeyMap(oneMap, "properties");
                retKeySet.addAll(loopRetKey(prev + key + ".", twoMap));
            }
        }

        return retKeySet;
    }
}
