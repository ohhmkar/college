#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct{
    int day;
    int month;
    int year;
}date;


struct FoodItem{
    int foodID;
    int quantity;
    char* foodName;
    char* category;
    date purchaseDate;
    date expiryDate;
    char* storageLocation;
    struct FoodItem *next;
};


struct FoodItem *head = NULL;

struct FoodItem* addFood(int foodID, int quantity, char* foodName, char* category, date purchaseDate, date expiryDate, char* storageLocation){
    struct FoodItem *newFoodItem;
    newFoodItem = (struct FoodItem* )malloc(sizeof(struct FoodItem));

    if(newFoodItem == NULL){
        printf("mem alloc failed!");
        exit(1);
    }
    newFoodItem->foodID = foodID;
    newFoodItem->quantity = quantity;
    newFoodItem->foodName = foodName;
    newFoodItem->category = category;
    newFoodItem->purchaseDate = purchaseDate;
    newFoodItem->expiryDate = expiryDate;
    newFoodItem->storageLocation = storageLocation;
    newFoodItem->next = NULL;
    printf("%s added!\n", foodName);

    if(head == NULL){
        head = newFoodItem;
        return head;
    }

    struct FoodItem* temp = head;

    while(temp->next!=NULL){
        temp = temp->next;
    }

    temp->next = newFoodItem;

    return head;


    return newFoodItem;
}


void searchFoodItemById(struct FoodItem* head, int searchID){
    struct FoodItem *temp = head;
    int pos = 1;
    if(temp == NULL){
        printf("No items in stock!");
        return;
    }
    while(temp!=NULL){
        if(temp->foodID == searchID){
            printf("Found item at position %d!",pos);
            return;
        }
        pos++;
    }
}

void updateQuantity(struct FoodItem* f,int newVal){
    f->quantity = newVal;
}

struct FoodItem* removeFood(struct FoodItem* head, int pos){
    if(head==NULL){
        printf("Nothing to be removed!\n");
        return head;
    }
    if(pos == 1){
        struct FoodItem* temp = head;
        head = head->next;
        free(temp);

        return(head);
    }
    struct FoodItem* temp = head;

    for(int i=0;i<pos-1 && temp!=NULL ;i++){
        temp = temp->next;
    }

    if(temp == NULL || temp->next == NULL){
        printf("Invalid deletion!\n");
        return head;
    }

    struct FoodItem* toBeDeleted = temp->next;

    temp->next = toBeDeleted->next;

    free(toBeDeleted);

    return head;
}


void displayAllFood(struct FoodItem* head){
    struct FoodItem* temp = head;
    if(temp==NULL){
        printf("Empty Storage!\n");
        return;
    }
    printf("Items stored: \n");
    int pos = 1;
    while(temp!=NULL){
        printf("%d.%s\n",pos,temp->foodName);
        pos++;
        temp = temp->next;
    }

}

int countCategory(struct FoodItem* head, char* category){
    struct FoodItem* temp = head;
    int count = 0;
    if(temp == NULL){
        printf("Nothing stored!\n");
        return -1;
    }

    while(temp!=NULL){
        if(temp->category == category){
            count++;
        }
        temp = temp->next;
    }
    return count;
}

int main()
{
    date date1 = {10,12,2026};
    date date2 = {10,12,2030};
    struct FoodItem* pizza = addFood(1,10,"Pizza","Expirable",date1,date2,"Fridge");
    struct FoodItem* pasta = addFood(2,20,"Pasta","Expirable",date1,date2,"Fridge");
    struct FoodItem* burger = addFood(3,20,"Burger","Expirable",date1,date2,"Outside");
    head = pizza;
    //printf("%s",pizza->foodName);
    //printf("%d-%d-%d",pizza->purchaseDate.day,pizza->purchaseDate.month,pizza->purchaseDate.year);
    //updateQuantity(pizza,20);
    //printf("%d",pizza->quantity);
    displayAllFood(head);
    printf("Expirable Count: %d",countCategory(head, "Expirable"));
}
