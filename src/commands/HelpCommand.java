package commands;

import utility.CommandResult;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help");
    }

    @Override
    public CommandResult execute(String arg) {
        return new CommandResult(false,
                "help : вывести справку по доступным командам\n"
                        + "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n"
                        + "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n"
                        + "add {element} : добавить новый элемент в коллекцию\n"
                        + "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n"
                        + "remove_by_id id : удалить элемент из коллекции по его id\n"
                        + "clear : очистить коллекцию\n"
                        + "save : сохранить коллекцию в файл\n"
                        + "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n"
                        + "exit : завершить программу (без сохранения в файл)\n"
                        + "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n"
                        + "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n"
                        + "history : вывести последние 6 команд (без их аргументов)\n"
                        + "average_of_impact_speed : вывести среднее значение поля impactSpeed для всех элементов коллекции\n"
                        + "count_less_than_impact_speed impactSpeed : вывести количество элементов, значение поля impactSpeed которых меньше заданного\n"
                        + "print_field_ascending_impact_speed : вывести значения поля impactSpeed всех элементов в порядке возрастания");
    }
}

