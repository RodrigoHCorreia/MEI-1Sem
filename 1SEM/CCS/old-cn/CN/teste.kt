import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*

// Injection of dependencies in service

data class Providers(
    val id: Int,
    val name: String,
    val url: URL,
    val is_active: boolean,
    val interval_to_fetch: Date,
    val last_request: Date,
)

@Service
class Service {

    fun getActiveProviders() : List<Providers>{
        //faz get à tabela, extrai os bacanos com active = true
    }
}

@Component
class ScheduledTasks {

    private val service = Service()

    private val dateFormat = SimpleDateFormat("HH:mm:ss")

    fun ex(){
        while(true){
            -
        }
    }
}
