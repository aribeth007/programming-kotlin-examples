package chappter9

//Both inheritance and delegation, promote reuse by way of extending one class from another.

//Delegation is more flexible than inheritance. An object may delegate or pass some of its responsibilities to an instance of another class.
// Different instances of a class may delegate to instances of different classes. It’s like the way siblings, with the same parents, can and do choose different friends.
//  inheritance - object of a class to be used in place of an object of another class.
// delegation - object of a class to  make use of an object of another class.
// in java a lot of duplicate code

interface Downloader {
    fun download()
}

interface Player {
    fun play()
}

class FileDownloader(private val file: String) : Downloader {
    override fun download() {
        println("Downloading $file")
    }

}

class FilePlayer(private val file: String) : Player {
    override fun play() {
        println("Playing $file")
    }
}

//class MediaFile(
//    private val downloader: Downloader,
//    private val player: Player
//) : Downloader, Player {
//    override fun download() {
//        downloader.download()
//    }
//    override fun play() {
//        player.play()
//    }
//
//}
// we can rewrite this code simpler
class MediaFile(
    private val downloader: Downloader,
    private val player: Player
) : Downloader by downloader, Player by player

fun main() {
    val file = "file.mp4"
    val mediaFile = MediaFile(FileDownloader(file), FilePlayer(file))
    mediaFile.download()
    mediaFile.play()
}
