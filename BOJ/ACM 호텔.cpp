#include <iostream>
#include <string>
using namespace std;

int testCase;
int height;
int low;
int room;
int result = 0;
int main()
{
	cin >> testCase;
	
	for (int i = 0; i < testCase; i++)
	{
		cin >> height >> low >> room;
		result = ((room-1) % height +1) * 100;
		result = result + ((room - 1) / height + 1);
		cout << result << endl;
		
	}
	return 0;
}