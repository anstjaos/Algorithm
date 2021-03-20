#include <iostream>
using namespace std;

typedef struct {
	float X;
	float Y;
}gimbab;

gimbab arr[102];
int n;
double result;

int main()
{
	gimbab temp;
	cin >> temp.X >> temp.Y;
	arr[0] = temp;
	cin >> n;
	
	result = (1000.0 / temp.Y) * temp.X;
	for (int i = 1; i <= n; i++)
	{
		cin >> arr[i].X >> arr[i].Y;
		double temp1 = (1000.0 / arr[i].Y) * arr[i].X;

		if (temp1 < result) result = temp1;
	}

	printf("%0.2f\n", result);
	return 0;
}