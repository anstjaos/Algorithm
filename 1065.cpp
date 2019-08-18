#include <iostream>
using namespace std;

int num;
int result = 0;
int arr[5];

void passingNum(int temp)
{
	int index = 0;
	while (temp != 0)
	{
		arr[index] = temp % 10;
		temp = temp / 10;
		index++;
	}
}

int main()
{
	cin >> num;

	if (num <= 99) result = num;
	else if (num == 1000) result = 144;
	else
	{
		passingNum(num);
		result = result + 99 + (arr[2] - 1) * 5;

		int temp = (arr[2] + 1) / 2;
		
		if (arr[1] < temp);
		else if (arr[1] == temp)
		{
			if (arr[2] - arr[1] >= arr[1] - arr[0]) result += 1;
		}
		else
		{
			if (arr[1] - temp > 5) result += 5;
			else
			{
				result += arr[1] - temp ;
				if (arr[2] - arr[1] >= arr[1] - arr[0]) result += 1;
			}
		}
	}

	cout << result << endl;
}