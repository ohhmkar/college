#include <stdio.h>
#include <stdlib.h>

/**
* @union
* @brief Stores temperatures values in union
* @author Omkar Anil Gajare
* @date 19-12-2025
*/
typedef union Temperature
{
    float celsius;
    float fahrenheit;
    char status;
} Temperature;
/**
* @struct
* @brief FullTemperature stores values in structs
* @author Omkar Anil Gajare
* @date 19-12-2025
*/
typedef struct FullTemperature
{
    float celsius;
    float fahrenheit;
    char status;
} FTemp;
/**
* @struct
* @brief Sensor struct stores final values
* @author Omkar Anil Gajare
* @date 19-12-2025
*/
typedef struct Sensor
{
    int id;
    char location[20];
    Temperature temp;
    struct FullTemperature ftemp;
} Sensor;
/**
* @brief Helper - Converts celsius to fahrenheit
* @author Omkar Anil Gajare
* @date
*/
float fahrenheitToCelsius(float celTemp)
{
    return ((9/5)*celTemp)+32;
}
/**
* @brief Helper - Converts fahrenheit to celsius
* @author Omkar Anil Gajare
* @date
*/
float celsiusToFahrenheit(float fahTemp)
{
    return ((5*(fahTemp-32)/9));
}
/**
* @brief Takes data entry of values
* @author Omkar Anil Gajare
* @date 19-12-2025
*/
struct Sensor inputData(struct Sensor sens,int n)
{
    if(n<=5)//If sensor limit isnt reached go ahead to take data
    {
        //Data Input of Values
        int tempType;
        printf("Enter Sensor Id: ");
        scanf("%d",&sens.id);
        printf("Enter Sensor Location: ");
        scanf("%s",&sens.location);
        printf("Enter Temperature type: (1. Celsius, 2.Fahrenheit): ");
        scanf("%d",&tempType);
        switch(tempType)
        {
        case 1://If Celsius Input is chosen, take celsius and convert to fahrenheit
            printf("Enter Value: ");
            scanf("%f",&(sens.temp.celsius));//Store input in union
            sens.ftemp.celsius = sens.temp.celsius;//Store union value in struct
            sens.ftemp.fahrenheit = celsiusToFahrenheit(sens.ftemp.celsius);//Store converted fahrenheit value
            break;
        case 2://If Fahrenheit Input is chosen, take fahrenheit and convert to celsius
            printf("Enter Value: ");
            scanf("%f",&(sens.temp.fahrenheit));//Store input in union
            sens.ftemp.fahrenheit = sens.temp.fahrenheit;//Store union value in struct
            sens.ftemp.celsius = fahrenheitToCelsius(sens.ftemp.fahrenheit);//Store converted celsius value
            break;
        }
        if(sens.ftemp.celsius<0)//IF LESS <0 LOW TEMPERATURE
        {
            sens.ftemp.status = 'L';
            sens.temp.status = sens.ftemp.status;
        }
        else if(sens.ftemp.celsius<100)//IF LESS THAN 100 but more than 0, NORMAL TEMEPRATURE
        {
            sens.ftemp.status = 'N';
            sens.temp.status = sens.ftemp.status;
        }
        else//IF MORE THAN 100, HIGH TEMPERATURE
        {
            sens.ftemp.status = 'H';
            sens.temp.status = sens.ftemp.status;
        }
        return sens;
    }
    else//IF CAPACITY REACHED SEND ERROR
    {
        printf("Sensor Capacity Reached!");
        return;
    }
}
/**
* @brief Displays values stored in Union
* @author Omkar Anil Gajare
* @date 19-12-2025
*/
void displayUnion(struct Sensor sens[],int n)
{
    //DISPLAYS UNION DATA IN TABULAR FORM
    printf("\n-------------------- ALL SENSOR DATA(with Union) -------------------\n");
    printf("Id\t\tLocation\tCelsius\t\tFahrenheit\tStatus\n");
    for(int i=0; i<n; i++)
    {
        printf("%d\t%14s\t%13.2f\t%14.2f\t %10c\n",sens[i].id,sens[i].location,sens[i].temp.celsius,sens[i].temp.fahrenheit,sens[i].temp.status);
    }

}
/**
* @brief Displays values stored in struct
* @author Omkar Anil Gajare
* @date 19-12-2025
*/
void displayStruct(struct Sensor sens[],int n)
{
    //DISPLAYS STRUCT DATA IN TABULAR FORM
    printf("\n-------------------- ALL SENSOR DATA(with Struct) -------------------\n");
    printf("Id\t\tLocation\tCelsius\t\tFahrenheit\tStatus\n");
    for(int i=0; i<n; i++)
    {
        printf("%d\t%14s\t%13.2f\t%14.2f\t %10c\n",sens[i].id,sens[i].location,sens[i].ftemp.celsius,sens[i].ftemp.fahrenheit,sens[i].ftemp.status);
    }
}
int main()
{
    Sensor sens[5];
    printf("\n\nOmkar Anil Gajare 2025300063\n\n");
    int choice = 0;
    int noOfSensors=0;
    while(choice!=4)
    {
        //MENU SETUP
        printf("\n=== Temperature Sensor Menu ===\n");
        printf("1. Add Sensor Data\n");
        printf("2. Display Sensor Data(Union)\n");
        printf("3. Display Sensor Data(Full Structure)\n");
        printf("4. Exit\n");
        printf("Enter Choice: ");
        scanf("%d",&choice);
        switch(choice)
        {
        case 1:
            //INPUT DATA CALL
            sens[noOfSensors] = inputData(sens[noOfSensors],noOfSensors);
            noOfSensors++;
            break;
        case 2:
            //CALL TO DISPLAY UNION
            displayUnion(sens,noOfSensors);
            break;
        case 3:
            //CALL TO DISPLAY STRUCT
            displayStruct(sens,noOfSensors);
            break;
        case 4:
            //EXIT CASE
            break;
        default:
            //INVALID CASE
            printf("Enter valid choice! (1-4)\n");
        }
    }
    printf("Exiting...");
    printf("\n\nOmkar Anil Gajare 2025300063");
    return 0;
}


