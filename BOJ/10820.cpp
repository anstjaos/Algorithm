#include <iostream>
using namespace std;

int testCase;
char input[101];
int arr[4];

void solve()
{
	for (int i = 0; i < 4; i++) arr[i] = 0;

	int index = 0;
	while (input[index] != '\0')
	{
		if ('a' <= input[index] && input[index] <= 'z') arr[0]++;
		else if ('A' <= input[index] && input[index] <= 'Z') arr[1]++;
		else if ('0' <= input[index] && input[index] <= '9') arr[2]++;
		else if (input[index] == ' ') arr[3]++;

		index++;
	}
}

int main()
{
	while(1)
	{
		cin.getline(input, 101);
		if (input[0] == '\0') break;
		solve();

		for (int i = 0; i < 4; i++) cout << arr[i] << " ";
		cout << '\n';
	}
	return 0;
}