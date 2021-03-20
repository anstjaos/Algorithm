#include <iostream>
using namespace std;

char arr1[2000001];
char arr2[2000001];
int A, B, C, D, arr1Index, arr2Index;
long long num1, num2;

void passing(int x, int y, char *arr, int &index)
{
	while (x != 0)
	{
		arr[index] = x % 10;
		x = x / 10;
		index++;
	}

	while (y!= 0)
	{
		arr[index] = y % 10;
		y= y / 10;
		index++;
	}
}

long long pow1(int num, int cnt)
{
	long long result = num;
	for (int i = 0; i < cnt; i++) result = result * 10;

	return result;
}

long long sum(char *arr, int index)
{
	long long result = 0;
	for (int i = 0; i < index; i++)
	{
		result = result + pow1((arr[i] ), i);
	}
	return result;
}

int main()
{
	cin >> A >> B >> C >> D;
	passing(B, A, arr1, arr1Index);
	passing(D, C, arr2, arr2Index);

	num1 = sum(arr1, arr1Index);
	num2 = sum(arr2, arr2Index);

	cout << num1 + num2 << '\n';
	return 0;
}