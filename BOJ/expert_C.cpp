#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/////////////////////////////////////
#define MAX_SIZE 1000001

struct CAR
{
	int age;       // 0 ~ 19
	int passenger; // 2 ~ 12
	int engine;    // 1000 ~ 4999
	int price;     // 10000 ~ 39999
};

typedef struct CarNode {
	CAR car;
	bool sell;
	CarNode *left;
	CarNode *right;
}CarNode;

int filter[4][2], poolCnt;
CarNode carPool[MAX_SIZE];
CarNode *carArr[20][14][5000];
CarNode *orderArr[MAX_SIZE];

void insertCar(CarNode *newCar)
{
	CAR car = newCar->car;
	newCar->sell = false;
	if (carArr[car.age][car.passenger][car.engine] == 0) carArr[car.age][car.passenger][car.engine] = newCar;
	else {
		carArr[car.age][car.passenger][car.engine]->left = newCar;
		newCar->right = carArr[car.age][car.passenger][car.engine];
		carArr[car.age][car.passenger][car.engine] = newCar;
	}
}

void buy(CAR car)
{
	carPool[poolCnt].car = car;
	CarNode *newCar = &carPool[poolCnt];
	newCar->left = 0;
	newCar->right = 0;

	poolCnt++;
	insertCar(newCar);
}


void filter_by_age(int from, int to)
{
	if (from > to)
	{
		int temp = from;
		from = to;
		to = temp;
	}

	filter[0][0] = from;
	filter[0][1] = to;
}


void filter_by_passenger(int from, int to)
{
	if (from > to)
	{
		int temp = from;
		from = to;
		to = temp;
	}

	filter[1][0] = from;
	filter[1][1] = to;
}


void filter_by_engine(int from, int to)
{
	if (from > to)
	{
		int temp = from;
		from = to;
		to = temp;
	}

	filter[2][0] = from;
	filter[2][1] = to;
}


void filter_by_price(int from, int to)
{
	if (from > to)
	{
		int temp = from;
		from = to;
		to = temp;
	}

	filter[3][0] = from;
	filter[3][1] = to;
}

void insertOrder(int order_number, CarNode *car)
{
	car->sell = true;
	car->left = 0;
	car->right = 0;

	if (orderArr[order_number] == 0) orderArr[order_number] = car;
	else {
		car->right = orderArr[order_number];
		orderArr[order_number]->left = car;
		orderArr[order_number] = car;
	}
}

bool checkCar(CarNode *car)
{
	if (filter[2][0] <= car->car.engine && car->car.engine <= filter[2][1]) {
		if (filter[3][0] <= car->car.price && car->car.price <= filter[3][1]) return true;
	}

	return false;
}

int sell(void)
{
	int order_number = 0;
	while (orderArr[order_number] != 0) order_number++;

	register int ageTo = filter[0][1];
	register int passengerTo = filter[1][1];
	register int engineTo = filter[2][1];

	for (register int age = filter[0][0]; age <= ageTo; age++)
	{
		for (register int pass = filter[1][0]; pass <= passengerTo; pass++) {
			for (register int engine = filter[2][0]; engine <= engineTo; engine++) {
				CarNode *ptr = carArr[age][pass][engine];
				while (ptr != 0)
				{
					CarNode *temp = ptr->right;
					if (filter[3][0] <= ptr->car.price && ptr->car.price <= filter[3][1])
					{
						if (ptr->left != 0) ptr->left->right = ptr->right;
						else carArr[age][pass][engine] = ptr->right;

						if (ptr->right != 0) ptr->right->left = ptr->left;

						insertOrder(order_number, ptr);
					}
					
					ptr = temp;
				}
			}
		}
	}

	return order_number; // order_number ( >= 0)
}


void refund(int order_number)
{
	while (orderArr[order_number] != 0)
	{
		CarNode *ptr = orderArr[order_number];
		orderArr[order_number] = orderArr[order_number]->right;
		insertCar(ptr);
	}
}


int empty(void)
{
	int cnt = 0;
	CarNode temp = { {0,0,0,0}, false, 0, 0};
	for (register int i = 0; i < poolCnt; i++) {
		if (!carPool[i].sell) cnt++;

		carPool[i] = temp;
	}

	for (register int i = 0; i < 20; i++) {
		for (register int j = 0; j < 14; j++) {
			for (register int k = 0; k < 5000; k++) carArr[i][j][k] = 0;
		}
	}

	for (register int i = 0; i < MAX_SIZE; i++) orderArr[i] = 0;
	poolCnt = 0;
	return cnt;
}

/////////////////////////////////////////////////
static void build(CAR* car)
{
	car->age = rand() % 20;
	car->passenger = 2 + (rand() % 11);
	car->engine = 1000 + (rand() % 4000);
	car->price = 10000 + (rand() % 30000);
}


static const int MAX_CAR = 1000000;


int main(void)
{
	setbuf(stdout, NULL);
	srand(3);

	int PERFORMANCE = 0;
	int order_number = -1;

	for (register int TRY = 1; TRY <= 10; TRY++)
	{
		printf("%d: ", TRY);
		time_t start = clock();

		for (register int c = 0; c < MAX_CAR; c++)
		{
			CAR car;

			build(&car);
			buy(car);

			if ((rand() % 100) == 0)
			{
				filter_by_age(rand() % 20, rand() % 20);
				filter_by_passenger(2 + (rand() % 11), 2 + (rand() % 11));
				filter_by_engine(1000 + (rand() % 4000), 1000 + (rand() % 4000));
				filter_by_price(10000 + (rand() % 30000), 10000 + (rand() % 30000));
				int ret = sell();
				if ((rand() % 10) == 0) order_number = ret;
			}

			if ((rand() % 10000) == 0)
			{
				if (order_number != -1)
				{
					refund(order_number);
					order_number = -1;
				}
			}
		}

		int RESULT = empty();
		order_number = -1;
		PERFORMANCE += ((clock() - start) / (CLOCKS_PER_SEC / 1000));
		printf("STOCK = %d\n", RESULT);
	}

	printf("PERFORMANCE = %d\n", PERFORMANCE);

	return 0;
}