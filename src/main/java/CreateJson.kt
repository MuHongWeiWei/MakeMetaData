import com.alibaba.fastjson.JSONObject
import java.io.File
import java.io.FileWriter


class CreateJson(index: Int) {

    private val rootObject = JSONObject()
    private var folderPath = ""
    private var writer: FileWriter

    init {
        folderPath = createFolder()
        writer = FileWriter("$folderPath/$index")
    }

    fun setData(description: String, name: String, i: Int) {
        rootObject["description"] = description
//        rootObject["animation_url"] = "https://badgameshow.com/dreamGarage/vip.mp4"
//        rootObject["image"] = "https://opensea.mypinata.cloud/ipfs/QmNMwoooLEkkU5SyjneHjawJVYXbWCuffcjqWEWziRsF1j"
        rootObject["image"] = "https://gateway.pinata.cloud/ipfs/QmSQ6p4cs49Mgutb6jxT4wYW6g6c5UYyJgeX4uQfHHCSU3/$i.png"
        rootObject["name"] = name
    }

    fun build() {
        writer.write(rootObject.toJSONString())
        writer.flush()
        writer.close()
    }

    private fun createFolder(): String {
        val jsonFile = File("metadata")
        if (!jsonFile.exists())
            jsonFile.mkdir()
        return jsonFile.path
    }
}