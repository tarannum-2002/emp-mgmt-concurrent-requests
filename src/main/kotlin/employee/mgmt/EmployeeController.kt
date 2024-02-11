package employee.mgmt

import employee.mgmt.entity.Employee
import employee.mgmt.service.EmployeeStore
//import io.micronaut.core.execution.ExecutionFlow.async
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.created
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Put
import kotlinx.coroutines.*
import kotlin.system.*

//@Controller("/employee")
//class EmployeeController(private val employeeStore: EmployeeStore) {
//
//    @Put
//    fun createOrUpdate(@Body createOrUpdateEmployee: Employee): HttpResponse<Employee> =
//            created(
//                    employeeStore.createOrUpdate(
//                            createOrUpdateEmployee.employeeId,
//                            createOrUpdateEmployee.name,
//                            createOrUpdateEmployee.city
//                    )
//            )
//
//    @Get("/{employeeId}")
//    fun get(employeeId: String): HttpResponse<Employee> =
//            employeeStore.get(employeeId)?.let { HttpResponse.ok(it) }
//                    ?: HttpResponse.notFound()
//}
//
@Controller("/employee")
class EmployeeController(private val employeeStore: EmployeeStore) {


    @Put
    suspend fun createOrUpdate(@Body createOrUpdateEmployee: Employee): HttpResponse<Employee> =
        created(
                employeeStore.createOrUpdate(
                        createOrUpdateEmployee.employeeId,
                        createOrUpdateEmployee.name,
                        createOrUpdateEmployee.city
                )
        )





    @Get("/{employeeId}")
    suspend fun get(employeeId: String): HttpResponse<Employee> =
            employeeStore.get(employeeId)?.let { HttpResponse.ok(it) }
                    ?: HttpResponse.notFound()
}

//@Controller("/employee")
//class EmployeeController(private val employeeStore: EmployeeStore) {
//
//    @Put
//    suspend fun createOrUpdate(@Body createOrUpdateEmployee: Employee): Flow<HttpResponse<Employee>> =
//            employeeStore.createOrUpdate(
//                    createOrUpdateEmployee.employeeId,
//                    createOrUpdateEmployee.name,
//                    createOrUpdateEmployee.city
//            ).map { HttpResponse.created(it) }
//
//    @Get("/{employeeId}")
//    suspend fun get(employeeId: String): Flow<HttpResponse<Employee>> =
//            employeeStore.get(employeeId).map { it?.let { HttpResponse.ok(it) } ?: HttpResponse.notFound() }
//}

