## Developer's Guide for GIC Banking App

### Layered Architecture:

The Banking App follows a layered architecture with distinct layers responsible for different aspects of the application:

1. **UI Layer:**
    - The UI layer is responsible solely for user interaction and presentation.
    - It has no business logic and focuses solely on receiving user input and displaying output.
    - This layer interfaces with the Banking System layer to process user requests.
    - The UI layer calls the `process` method from the Banking System layer to initiate banking operations.

2. **Banking System Layer:**
    - The Banking System layer acts as the intermediary between the UI layer and the underlying business logic.
    - It coordinates user requests, executes banking operations, and returns responses to the UI layer.
    - This layer interfaces with the Parser layer to parse user input and generate corresponding commands.
    - This layer also interfaces with the Command layer to execute commands on the Account model.

3. **Parser Layer:**
    - The Parser layer is responsible for parsing user input and converting it into executable commands.
    - It receives user input from the Banking System layer and processes it to identify the intended banking operation.
    - Parser parses the input and generates a corresponding command object, which is then passed to the Banking System layer for execution.

4. **Command Layer:**
    - The Command layer encapsulates individual banking commands, such as DepositCommand, WithdrawCommand, PrintCommand, and QuitCommand.
    - Each command class implements the `execute` method, which performs the specific banking operation on the Account model.
    - Command objects are created by the Parser layer based on user input and are executed by the Banking System layer.

### Integration Flow:

1. The **UI layer** presents the main menu and awaits user input.
2. Upon receiving user input, the **UI layer** calls the `process` method from the **Banking System** layer to handle the request.
3. The **Banking System** layer interacts with the **Parser** layer to parse the user input and generate a corresponding **command** object.
4. **Banking System** layer executes the **command** on the **Account** model, which performs the necessary banking operation.
5. After executing the **command**, the **Banking System** layer returns the response to the **UI layer** for display.

By adhering to this layered architecture, the Banking App achieves modularity, separation of concerns, and scalability, making it easier to maintain and extend over time.
