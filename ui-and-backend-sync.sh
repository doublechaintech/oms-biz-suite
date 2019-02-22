
MODELNAME=oms
cd ~/githome/-biz-suite/&& git pull --allow-unrelated-histories && cd ../
cd ~/githome/-biz-suite/bizcore&& gradle classes && cd ../../
cd ~/githome/-biz-suite/ && rsync -avz   bizcore/* philipz@philip.doublechaintech.cn:~/resin-3.1.12/webapps//
ssh philipz@philip.doublechaintech.cn "mysql -uroot -p0254891276 -h 127.0.0.1 < resin-3.1.12/webapps//WEB-INF/_core_src/META-INF/_mysql.sql"
cd ~/githome/-biz-suite/bizui&& yarn install && yarn build && cd ../../
cd ~/githome/-biz-suite/bizui && rsync -avz   dist/* philipz@philip.doublechaintech.cn:~/resin-3.1.12/webapps/ROOT/admin//

