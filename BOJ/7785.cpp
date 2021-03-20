#include <iostream>
#include <string>
#include <set>
using namespace std;

set<string> logArr;
int N;
char name[50], logData[50];

int main()
{
	scanf("%d ", &N);

	for (int i = 0; i < N; i++)
	{
		scanf("%s %s ", name, logData);
		string s(name);
		if (logData[0] == 'e')
		{
			logArr.insert(s);
		}
		else logArr.erase(s);
	}

	set<string>::reverse_iterator iter = logArr.rbegin();

	for (iter; iter != logArr.rend(); iter++)
	{
		printf("%s\n", (*iter).c_str());

	}
	return 0;
}