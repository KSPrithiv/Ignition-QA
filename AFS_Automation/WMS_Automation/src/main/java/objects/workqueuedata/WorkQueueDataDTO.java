package objects.workqueuedata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WorkQueueDataDTO implements Serializable {
	@JsonProperty("assignment numbers")
	private AssignmentNumbersDTO assignmentNumbers;
	@JsonProperty("routes")
	private RoutesDTO routes;
	@JsonProperty("stops")
	private StopsDTO stops;
	@JsonProperty("tasks")
	private TasksDTO tasks;
	@JsonProperty("qties")
	private QtiesDTO qties;
	@JsonProperty("cubes")
	private CubesDTO cubes;
	@JsonProperty("assign to")
	private AssignToDTO assignTo;
	@JsonProperty("in use by")
	private InUseByDTO inUseBy;
	@JsonProperty("% picked")
	private PickedDTO picked;
	@JsonProperty("weights")
	private WeightsDTO weights;
	@JsonProperty("shippers")
	private ShippersDTO shippers;
	@JsonProperty("ship to")
	private ShipToDTO shipTo;
	@JsonProperty("remaining")
	private RemainingDTO remaining;
	@JsonProperty("est. time")
	private EstTimeDTO estTime;
	@JsonProperty("users")
	private UsersDTO usersDTO;
	@JsonProperty("task groups")
	private TaskGroupDTO taskGroupDTO;
	@JsonProperty("logged-in users")
	private LoggedInUsersDTO loggedInUsersDTO;
	@JsonProperty("user ids")
	private UserIdsDTO userIdsDTO;
	@JsonProperty("computers")
	private ComputersDTO computersDTO;
	@JsonProperty("logout reasons")
	private LogoutUsersDTO logoutUsersDTO;
	@JsonProperty("task list products")
	private TaskListProductsDTO taskListProductsDTO;
	@JsonProperty("task list from")
	private TaskListFromDTO taskListFromDTO;
	@JsonProperty("task list to")
	private TaskListToDTO taskListToDTO;
	@JsonProperty("task list status")
	private TaskListStatusDTO taskListStatusDTO;
	@JsonProperty("task list priorities")
	private TaskListPrioritiesDTO taskListPrioritiesDTO;
	@JsonProperty("task list velocities")
	private TaskListVelocitiesDTO taskListVelocitiesDTO;
	@JsonProperty("task list descriptions")
	private TaskListDescriptionsDTO taskListDescriptionsDTO;
}