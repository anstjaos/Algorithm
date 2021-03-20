#include <iostream>
using namespace std;

int N, M;
int arr[102];
int num1, num2;

int main()
{
	cin >> N >> M;
	for (int i = 1; i <= N; i++) arr[i] = i;

	for (int i = 0; i < M; i++)
	{
		cin >> num1 >> num2;
		int temp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = temp;
	}

	for (int i = 1; i <= N; i++) cout << arr[i] << " ";
	cout << endl;
	return 0;
}