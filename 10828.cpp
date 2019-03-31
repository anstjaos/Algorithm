#include <iostream>
#include <string>
using namespace std;

int stack[100001];
int top = -1;

int main()
{
	int test;
	cin >> test;

	for (int i = 0; i < test; i++)
	{
		string input;
		cin >> input;

		if (input == "push")
		{
			int num;
			cin >> num;
			stack[++top] = num;
		}
		else if (input == "pop")
		{
			if (top == -1)
			{
				cout << "-1" << endl;
			}
			else
			{
				int num = stack[top--];
				cout << num << endl;
			}
		}
		else if (input == "size")
		{
			cout << top + 1 << endl;
		}
		else if (input == "empty")
		{
			if (top == -1) cout << "1" << endl;
			else cout << "0" << endl;
		}
		else if (input == "top")
		{
			if (top == -1) cout << "-1" << endl;
			else cout << stack[top] << endl;
		}
	}
	return 0;
}