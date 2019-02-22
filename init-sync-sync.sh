
MODELNAME=$1
mkdir -p ~/githome/
cd ~/githome && git clone https://github.com/doublechaintech/${MODELNAME}-biz-suite.git
cd ~/githome/${MODELNAME}-biz-suite/bizcore&& gradle classes && cd ../../
cd ~/githome/${MODELNAME}-biz-suite/bizui&& cp -Ra ~/githome/pim-biz-suite/bizui/src/common/* src/common/ 
cd ~/githome/${MODELNAME}-biz-suite/bizui&& yarn install && yarn build && cd ../../
ssh philipz@philip.doublechaintech.cn "mkdir ~/resin-3.1.12/webapps/${MODELNAME}"
ssh philipz@philip.doublechaintech.cn "mkdir ~/resin-3.1.12/webapps/ROOT/admin/${MODELNAME}"
cd ~/githome/${MODELNAME}-biz-suite/ && rsync -avz   bizcore/* philipz@philip.doublechaintech.cn:~/resin-3.1.12/webapps/${MODELNAME}/
cd ~/githome/${MODELNAME}-biz-suite/bizui && rsync -avz   dist/* philipz@philip.doublechaintech.cn:~/resin-3.1.12/webapps/ROOT/admin/${MODELNAME}/
ssh philipz@philip.doublechaintech.cn "mysql -uroot -p0254891276 -h 127.0.0.1 < resin-3.1.12/webapps/${MODELNAME}/WEB-INF/${MODELNAME}_core_src/META-INF/${MODELNAME}_mysql.sql"













